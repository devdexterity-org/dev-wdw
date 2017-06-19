/**
 * 用户管理页面
 */
var UserManageCtrl = (function () {
    var that;
    var obj = function () {
        that = this;
    };

    obj.prototype = {
        ctrl: function () {
        },
        
        /**
         * 删除用户
         */
        delUser:function(openUid){
        	Util.ajax({
                method: "POST",
                data: openUid,
                url: "DeleteUser"
            }, function (data) {
                if (data.success) {// 提交成功
                    Util.info("删除成功");
                }
                else {
                    Util.info(data.error);
                }
            });
        },
        
        /**
         * 编辑用户
         */
        editUser:function(openUid){
        	window.location.href = "UserEdit?openUid=" + openUid;
        },
        
        /**
         * 添加用户
         */
        addUser:function(){
        	window.location.href = "UserAdd";
        },
        
        /**
         * 查询
         */
        search:function(){
        	var searchTxt = $("#search_text").val().trim();
        	Util.ajax({
                method: "POST",
                data: searchTxt,
                url: "QueryUser"
            }, function (data) {
                if (data.success) {// 提交成功
                	
                }
                else {
                    Util.info(data.error);
                }
            });
        }
        
    };
    return new obj();

})();