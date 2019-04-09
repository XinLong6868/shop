package com.fh.shop.backend.util;

public class CacheManager {
    private BaseCache bc;
    private static volatile CacheManager instance;
    private static Object lock = new Object();
    private CacheManager(){
         bc = new BaseCache("fh_shop", 24*60*60);
    }
//双重判定锁
    public static CacheManager getInstance(){
        if (instance == null){
            synchronized( lock ){
                if (instance == null){
                    instance = new CacheManager();
                }
            }
        }
        return instance;
    }
//手动刷新往缓存中存值
    public void putObj(String ids,Object obj){
        bc.put(ids,obj);
    }
 //自动刷新往缓存中存值
    public void putObj(String ids,Object obj, int expire){
        bc.put(ids,obj,expire);
    }
//获取缓存中的值
    public Object getObj(String ids){
        try {
            return bc.get(ids);
        } catch (Exception e) {
        	return null;
        }
    }
//清除缓存
    public void remove(String ids){
        bc.remove(ids);
    }
    public void removeAll(){
        bc.removeAll();
    }

}
