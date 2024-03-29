package tommista.com.turbine.managers;

import java.util.ArrayList;

import tommista.com.turbine.models.Handle;

/**
 * Created by tbrown on 1/17/15.
 */
public class HandleManager {

    private static HandleManager instance;
    private ArrayList<Handle> handleList;

    public static HandleManager getInstance() {
        if (instance == null) {
            instance = new HandleManager();
        }
        return instance;
    }

    private HandleManager() {
        handleList = new ArrayList<Handle>();
       // handleList.add(new Handle("@thomasbrown333"));
        //handleList.add(new Handle("@jberidon"));
    }

    public void addHandle(String name) {
        boolean add = true;
        for (Handle handle : handleList) {
            if (handle.getTwitterHandle().equals(name)) {
                add = false;
                break;
            }
        }
        if (add) handleList.add(new Handle(name));
    }

    public void deleteHandle(String handleName) {

            for (Handle handle : getHandleList()) {
                if (handle.getTwitterHandle().compareTo(handleName) == 0) {
                        TweetManager.getInstance().deleteTweetsByHandle(handle);
                        handleList.remove(handle);

                }
            }

    }



    public ArrayList<Handle> getHandleList(){
        return new ArrayList<>(handleList);
    }


}
