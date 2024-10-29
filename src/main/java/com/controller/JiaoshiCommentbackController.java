
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 教师评价
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaoshiCommentback")
public class JiaoshiCommentbackController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoshiCommentbackController.class);

    private static final String TABLE_NAME = "jiaoshiCommentback";

    @Autowired
    private JiaoshiCommentbackService jiaoshiCommentbackService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JiaoshiService jiaoshiService;//教师
    @Autowired
    private JiaoshiCollectionService jiaoshiCollectionService;//教师收藏
    @Autowired
    private JiaoshiYuyueService jiaoshiYuyueService;//预约信息
    @Autowired
    private KechengService kechengService;//课程
    @Autowired
    private KechengCollectionService kechengCollectionService;//课程收藏
    @Autowired
    private KechengLiuyanService kechengLiuyanService;//课程留言
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jiaoshiCommentbackService.queryPage(params);

        //字典表数据转换
        List<JiaoshiCommentbackView> list =(List<JiaoshiCommentbackView>)page.getList();
        for(JiaoshiCommentbackView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoshiCommentbackEntity jiaoshiCommentback = jiaoshiCommentbackService.selectById(id);
        if(jiaoshiCommentback !=null){
            //entity转view
            JiaoshiCommentbackView view = new JiaoshiCommentbackView();
            BeanUtils.copyProperties( jiaoshiCommentback , view );//把实体数据重构到view中
            //级联表 教师
            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(jiaoshiCommentback.getJiaoshiId());
            if(jiaoshi != null){
            BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "jiaoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiaoshiId(jiaoshi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiaoshiCommentback.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "jiaoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoshiCommentbackEntity jiaoshiCommentback, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoshiCommentback:{}",this.getClass().getName(),jiaoshiCommentback.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiaoshiCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("教师".equals(role))
            jiaoshiCommentback.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jiaoshiCommentback.setCreateTime(new Date());
        jiaoshiCommentback.setInsertTime(new Date());
        jiaoshiCommentbackService.insert(jiaoshiCommentback);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoshiCommentbackEntity jiaoshiCommentback, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiaoshiCommentback:{}",this.getClass().getName(),jiaoshiCommentback.toString());
        JiaoshiCommentbackEntity oldJiaoshiCommentbackEntity = jiaoshiCommentbackService.selectById(jiaoshiCommentback.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiaoshiCommentback.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("教师".equals(role))
//            jiaoshiCommentback.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        jiaoshiCommentback.setUpdateTime(new Date());

            jiaoshiCommentbackService.updateById(jiaoshiCommentback);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiaoshiCommentbackEntity> oldJiaoshiCommentbackList =jiaoshiCommentbackService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiaoshiCommentbackService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<JiaoshiCommentbackEntity> jiaoshiCommentbackList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiaoshiCommentbackEntity jiaoshiCommentbackEntity = new JiaoshiCommentbackEntity();
//                            jiaoshiCommentbackEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            jiaoshiCommentbackEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiaoshiCommentbackEntity.setJiaoshiCommentbackText(data.get(0));                    //评价内容 要改的
//                            jiaoshiCommentbackEntity.setInsertTime(date);//时间
//                            jiaoshiCommentbackEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            jiaoshiCommentbackEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            jiaoshiCommentbackEntity.setCreateTime(date);//时间
                            jiaoshiCommentbackList.add(jiaoshiCommentbackEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiaoshiCommentbackService.insertBatch(jiaoshiCommentbackList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiaoshiCommentbackService.queryPage(params);

        //字典表数据转换
        List<JiaoshiCommentbackView> list =(List<JiaoshiCommentbackView>)page.getList();
        for(JiaoshiCommentbackView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoshiCommentbackEntity jiaoshiCommentback = jiaoshiCommentbackService.selectById(id);
            if(jiaoshiCommentback !=null){


                //entity转view
                JiaoshiCommentbackView view = new JiaoshiCommentbackView();
                BeanUtils.copyProperties( jiaoshiCommentback , view );//把实体数据重构到view中

                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(jiaoshiCommentback.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiaoshiCommentback.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoshiCommentbackEntity jiaoshiCommentback, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaoshiCommentback:{}",this.getClass().getName(),jiaoshiCommentback.toString());
        jiaoshiCommentback.setCreateTime(new Date());
        jiaoshiCommentback.setInsertTime(new Date());
        jiaoshiCommentbackService.insert(jiaoshiCommentback);

            return R.ok();
        }

}

