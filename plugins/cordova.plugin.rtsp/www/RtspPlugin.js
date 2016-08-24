/**
 * Created by Administrator on 2016-08-23.
 */
//TODO 导入依赖库
var exec = require('cordova/exec');
var platform = require('cordova/platform');

module.exports = {
    // TODO JS 中调用的 js方法，参数列表可根据业务需求定
    play: function (args, success, error) {
        //TODO 参数（回调方法,null,类名，方法名，[参数1，参数2，……]）
        exec(success, error, "RtspPlugin", "play", [args]);
    },
    stop: function (args, success, error) {
        //TODO 参数（回调方法,null,类名，方法名，[参数1，参数2，……]）
        exec(success, error, "RtspPlugin", "stop", [args]);
    }
}
