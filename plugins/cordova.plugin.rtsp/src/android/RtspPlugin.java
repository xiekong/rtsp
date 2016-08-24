package cordova.plugin.rtsp;

import android.app.Activity;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by XieKong on 2016-08-22.
 */
public class RtspPlugin extends CordovaPlugin {
    private CallbackContext callbackContext;
    public static final String PLAY_ACTION = "play";
    public static final String STOP_ACTION = "stop";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            this.callbackContext = callbackContext;
            //根据action判断调用方法
            if (PLAY_ACTION.equals(action)) {
                String rtspUrl = args.getString(0); //"rtsp://218.204.223.237:554/live/1/67A7572844E51A64/f68g2mj7wjua3la7.sdp"
                //通过Intent绑定将要调用的Activity
                Intent intent = new Intent().setClass(cordova.getActivity(), RtspActivity.class);
                //加入将要传输到activity中的参数
                intent.putExtra("rtspUrl", rtspUrl);
                //启动activity
                this.cordova.startActivityForResult(this, intent, 0);
                //下面三句为cordova插件回调页面的逻辑代码
//                PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
//                pluginResult.setKeepCallback(true);
//                callbackContext.sendPluginResult(pluginResult);
//                callbackContext.success("success");
//                String msg = args.getString(0)+"'s dream is to become a "+args.getString(1);
//                callbackContext.success(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //onActivityResult为第二个Activity执行完后的回调接收方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        // 根据resultCode判断处理结果
        switch (resultCode) {
            case Activity.RESULT_OK:
                String message = intent.getStringExtra("message");
                //设置回调success函数
                callbackContext.success(message);
                break;
            default:
                break;
        }
    }
}
