/**
 * 
 */
var Util = (function () {
    var that;
    var obj = function () {
        that = this;

        this.ajaxCount = 0;
        this.popId = [];

    };

    obj.prototype = {
        
        info: function (msg) {
           
            $(".pop_info").remove();

            var div = document.createElement("div");
            div.className = "pop_info";
            div.style.cssText = "position:fixed;top:20%;left:0;width:100%;text-align:center;z-index:10000;";

            var innerDiv = document.createElement("div");
            innerDiv.style.cssText = "display:inline-block;background-color:rgba(0,0,0,0.8);border-radius:3px;padding:5px 8px;color:white;";
            innerDiv.innerHTML = msg;
            div.appendChild(innerDiv);

            document.body.appendChild(div);//top.
            setTimeout(function () {
                $(div).remove();
            }, 3000);
        },

        ajax: function (option, callback) {
            $.ajax({
                type: option.method?option.method:"POST",
                url: option.url,
                data: option.data,
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                timeout: 8000,
                success: function (data) {
                    if (callback) {
                        callback(data);
                       
                    }
                },
                error: function (e, msg) {
                    console.log(msg);
                    that.info("请重试");
                }
            });
        },
        
        showLoading: function (isBackend) {
            this.ajaxCount++;

            var loading = document.getElementById("loading");//top.
            if (!loading) {
                loading = document.createElement("div");
                loading.id = "loading";
                loading.style.zIndex = 1001;
                loading.style.width = "100%";
                loading.style.height = "100%";
                loading.style.top = "0";
                loading.style.left = "0";
                loading.style.textAlign = "center";
                loading.style.position = "fixed";
                if (isBackend == true) {
                    loading.innerHTML = '<div style="width: 14%;margin-top: 20%;margin-left: 43%;"><img src="../Static/images/loading_new.gif" style="width: 20%;border-radius: 8%;"><div style="color: #fff;margin-top: 5px;font-family: 微软雅黑;font-size: 20px;">加载中...</div></div>';
                } else {
                    loading.innerHTML = '<div style="width: 30%;margin-top: 50%;margin-left: 35%;"><img src="../Static/images/loading_new.gif" style="width: 20%;border-radius: 8%;"><div style="color: #fff;margin-top: 5px;font-family: 微软雅黑;font-size: 15px;">加载中...</div></div>';
                }
                document.body.appendChild(loading);//top.
            }
        },

        hideLoading: function () {
            this.ajaxCount--;
            if (this.ajaxCount <= 0) {
                var loading = document.getElementById("loading");//top.
                if (loading) {
                    document.body.removeChild(loading);//top.
                }
                this.ajaxCount = 0;
            }
        }
    };

    return new obj();
})();