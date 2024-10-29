
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
 * 课程
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kecheng")
public class KechengController {
    private static final Logger logger = LoggerFactory.getLogger(KechengController.class);

    private static final String TABLE_NAME = "kecheng";

    @Autowired
    private KechengService kechengService;


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
    private JiaoshiCommentbackService jiaoshiCommentbackService;//教师评价
    @Autowired
    private JiaoshiYuyueService jiaoshiYuyueService;//预约信息
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
        params.put("kechengDeleteStart",1);params.put("kechengDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = kechengService.queryPage(params);

        //字典表数据转换
        List<KechengView> list =(List<KechengView>)page.getList();
        for(KechengView c:list){
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
        KechengEntity kecheng = kechengService.selectById(id);
        if(kecheng !=null){
            //entity转view
            KechengView view = new KechengView();
            BeanUtils.copyProperties( kecheng , view );//把实体数据重构到view中
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
    public R save(@RequestBody KechengEntity kecheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kecheng:{}",this.getClass().getName(),kecheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KechengEntity> queryWrapper = new EntityWrapper<KechengEntity>()
            .eq("kecheng_name", kecheng.getKechengName())
            .eq("kecheng_video", kecheng.getKechengVideo())
            .eq("kecheng_types", kecheng.getKechengTypes())
            .eq("zan_number", kecheng.getZanNumber())
            .eq("cai_number", kecheng.getCaiNumber())
            .eq("kecheng_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechengEntity kechengEntity = kechengService.selectOne(queryWrapper);
        if(kechengEntity==null){
            kecheng.setKechengClicknum(1);
            kecheng.setKechengDelete(1);
            kecheng.setInsertTime(new Date());
            kecheng.setCreateTime(new Date());
            kechengService.insert(kecheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KechengEntity kecheng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,kecheng:{}",this.getClass().getName(),kecheng.toString());
        KechengEntity oldKechengEntity = kechengService.selectById(kecheng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(kecheng.getKechengPhoto()) || "null".equals(kecheng.getKechengPhoto())){
                kecheng.setKechengPhoto(null);
        }
        if("".equals(kecheng.getKechengVideo()) || "null".equals(kecheng.getKechengVideo())){
                kecheng.setKechengVideo(null);
        }

            kechengService.updateById(kecheng);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<KechengEntity> oldKechengList =kechengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<KechengEntity> list = new ArrayList<>();
        for(Integer id:ids){
            KechengEntity kechengEntity = new KechengEntity();
            kechengEntity.setId(id);
            kechengEntity.setKechengDelete(2);
            list.add(kechengEntity);
        }
        if(list != null && list.size() >0){
            kechengService.updateBatchById(list);
        }

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
            List<KechengEntity> kechengList = new ArrayList<>();//上传的东西
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
                            KechengEntity kechengEntity = new KechengEntity();
//                            kechengEntity.setKechengName(data.get(0));                    //课程标题 要改的
//                            kechengEntity.setKechengPhoto("");//详情和图片
//                            kechengEntity.setKechengVideo(data.get(0));                    //视频 要改的
//                            kechengEntity.setKechengTypes(Integer.valueOf(data.get(0)));   //课程类型 要改的
//                            kechengEntity.setKechengClicknum(Integer.valueOf(data.get(0)));   //热度 要改的
//                            kechengEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            kechengEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            kechengEntity.setKechengContent("");//详情和图片
//                            kechengEntity.setKechengDelete(1);//逻辑删除字段
//                            kechengEntity.setInsertTime(date);//时间
//                            kechengEntity.setCreateTime(date);//时间
                            kechengList.add(kechengEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        kechengService.insertBatch(kechengList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<KechengView> returnKechengViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("kechengYesnoTypes",2);
        PageUtils pageUtils = kechengCollectionService.queryPage(params1);
        List<KechengCollectionView> collectionViewsList =(List<KechengCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(KechengCollectionView collectionView:collectionViewsList){
            Integer kechengTypes = collectionView.getKechengTypes();
            if(typeMap.containsKey(kechengTypes)){
                typeMap.put(kechengTypes,typeMap.get(kechengTypes)+1);
            }else{
                typeMap.put(kechengTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("kechengTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("kechengYesnoTypes",2);
            PageUtils pageUtils1 = kechengService.queryPage(params2);
            List<KechengView> kechengViewList =(List<KechengView>)pageUtils1.getList();
            returnKechengViewList.addAll(kechengViewList);
            if(returnKechengViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("kechengYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = kechengService.queryPage(params);
        if(returnKechengViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnKechengViewList.size();//要添加的数量
            List<KechengView> kechengViewList =(List<KechengView>)page.getList();
            for(KechengView kechengView:kechengViewList){
                Boolean addFlag = true;
                for(KechengView returnKechengView:returnKechengViewList){
                    if(returnKechengView.getId().intValue() ==kechengView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnKechengViewList.add(kechengView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnKechengViewList = returnKechengViewList.subList(0, limit);
        }

        for(KechengView c:returnKechengViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnKechengViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = kechengService.queryPage(params);

        //字典表数据转换
        List<KechengView> list =(List<KechengView>)page.getList();
        for(KechengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KechengEntity kecheng = kechengService.selectById(id);
            if(kecheng !=null){

                //点击数量加1
                kecheng.setKechengClicknum(kecheng.getKechengClicknum()+1);
                kechengService.updateById(kecheng);

                //entity转view
                KechengView view = new KechengView();
                BeanUtils.copyProperties( kecheng , view );//把实体数据重构到view中

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
    public R add(@RequestBody KechengEntity kecheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kecheng:{}",this.getClass().getName(),kecheng.toString());
        Wrapper<KechengEntity> queryWrapper = new EntityWrapper<KechengEntity>()
            .eq("kecheng_name", kecheng.getKechengName())
            .eq("kecheng_video", kecheng.getKechengVideo())
            .eq("kecheng_types", kecheng.getKechengTypes())
            .eq("kecheng_clicknum", kecheng.getKechengClicknum())
            .eq("zan_number", kecheng.getZanNumber())
            .eq("cai_number", kecheng.getCaiNumber())
            .eq("kecheng_delete", kecheng.getKechengDelete())
//            .notIn("kecheng_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KechengEntity kechengEntity = kechengService.selectOne(queryWrapper);
        if(kechengEntity==null){
            kecheng.setKechengClicknum(1);
                kecheng.setZanNumber(1);
                kecheng.setCaiNumber(1);
            kecheng.setKechengDelete(1);
            kecheng.setInsertTime(new Date());
            kecheng.setCreateTime(new Date());
        kechengService.insert(kecheng);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

