/**
 * 用户明细页面
 */
var UserDetailCtrl = (function () {
    var that;
    var obj = function () {
        that = this;
    };

    obj.prototype = {
        ctrl: function () {
        },
        
        /**
         * 提交
         */
        submit:function(type,openUid){
        	var openId = $("#openId").val();
        	var userName = $("#userName").val();
        	var userTel = $("#userTel").val();
        	var headImg = $("#headImg").attr("src");
        	var param = {};
        	param.openUid = openUid;
        	param.openId = openId;
        	param.userName = userName;
        	param.userTel =  userTel;
        	param.headImg = headImg;
        	console.log(param);
    		Util.ajax({
                method: "POST",
                data: JSON.stringify(param),
                url: "SaveUser"
            }, function (data) {
                if (data.success) {// 提交成功
                    Util.info("保存成功");
                }
                else {
                    Util.info(data.error);
                }
            });
        },
        
        /**
         * 返回
         */
        goBack:function(){
        	window.location.href="UserManage";
        },
        
    };
    return new obj();

})();