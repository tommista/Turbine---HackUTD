package tommista.com.turbine.managers;

import java.util.ArrayList;

import tommista.com.turbine.models.Handle;

/**
 * Created by tbrown on 1/17/15.
 */
public class HandleManager {

    private static HandleManager instance;
    private ArrayList<Handle> handleList;

    public static HandleManager getInstance(){
        if(instance == null){
            instance = new HandleManager();
        }
        return instance;
    }

    private HandleManager(){
        handleList = new ArrayList<Handle>();


        //creating and adding test handles
        Handle test1 = new Handle("@Test1");
        Handle test2 = new Handle("@Test2");
        Handle test3 = new Handle("@Test3");
        addHandle(test1);
        addHandle(test2);
        addHandle(test3);
    }

    public void addHandle(Handle handle){
        handleList.add(handle);
    }

    public void deleteHandle(String handleName){
        for(Handle handle : handleList){
            if(handle.getTwitterHandle().compareTo(handleName) == 0)
            {
                handleList.remove(handle);
            }
        }
    }

    public ArrayList<Handle> getHandleList(){
        return handleList;
    }


}
