/**
 * goable variable,
 * common functions
 */
var curpage = 1;
var pageSize= 20;

function uploadFile(fileType,id,fileInput,callback){
	 $.ajaxFileUpload({  
     	url: '/fileupload?fileType='+fileType+'&id='+id,   
     	secureuri: false,  
     	fileElementId: fileInput,  
     	dataType: 'json',  
     	success: function (data, status){ 
	 		if (data.error != null) {
	 			if (data.error!='没有文件') {
	 				alert(data.error);
	 			}	
	        } else {
	        	callback(id,data.path);
	        }
     	},
     	error: function (data, status, e){
     		alert("上传文件失败，"+e);
     	}  
 	});
}

var clientApiUrl = "/";
	function ajaxErrorHander(XMLHttpResponse,customHander){
		if(XMLHttpResponse.statusCode().status==401){//身份验证不通过
			window.location.href = "index.html";
		}else if(XMLHttpResponse.statusCode().status==403){//只是没有操作权限
			alert("没有操作权限");
		}else if(XMLHttpResponse.statusCode().status==500){//只是没有操作权限
			try{
				var text = $.parseJSON(XMLHttpResponse.responseText);
				alert(text.msg);
			}catch(e){}
		}else{
			customHander(XMLHttpResponse.responseText);	
		}
	}

    
    /*
     * Generate a random uuid.
     *
     * USAGE: Math.uuid(length, radix)
     *   length - the desired number of characters
     *   radix  - the number of allowable values for each character.
     *
     * EXAMPLES:
     *   // No arguments  - returns RFC4122, version 4 ID
     *   >>> Math.uuid()
     *   "92329D39-6F5C-4520-ABFC-AAB64544E172"
     *
     *   // One argument - returns ID of the specified length
     *   >>> Math.uuid(15)     // 15 character ID (default base=62)
     *   "VcydxgltxrVZSTV"
     *
     *   // Two arguments - returns ID of the specified length, and radix. (Radix must be <= 62)
     *   >>> Math.uuid(8, 2)  // 8 character ID (base=2)
     *   "01001010"
     *   >>> Math.uuid(8, 10) // 8 character ID (base=10)
     *   "47473046"
     *   >>> Math.uuid(8, 16) // 8 character ID (base=16)
     *   "098F4D35"
     */
    (function() {
      // Private array of chars to use
//      var CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
      var CHARS = '0123456789abcdefghijklmnopqrstuvwxyz'.split('');
      
      Math.uuid = function (len, radix) {
        var chars = CHARS, uuid = [], i;
        radix = radix || chars.length;
     
        if (len) {
          // Compact form
          for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
        } else {
          // rfc4122, version 4 form
          var r;
     
          // rfc4122 requires these characters
          uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
          uuid[14] = '4';
     
          // Fill in random data.  At i==19 set the high bits of clock sequence as
          // per rfc4122, sec. 4.1.5
          for (i = 0; i < 36; i++) {
            if (!uuid[i]) {
              r = 0 | Math.random()*16;
              uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
            }
          }
        }
     
        return uuid.join('');
      };
     
      // A more performant, but slightly bulkier, RFC4122v4 solution.  We boost performance
      // by minimizing calls to random()
      Math.uuidFast = function() {
        var chars = CHARS, uuid = new Array(36), rnd=0, r;
        for (var i = 0; i < 36; i++) {
          if (i==8 || i==13 ||  i==18 || i==23) {
            uuid[i] = '-';
          } else if (i==14) {
            uuid[i] = '4';
          } else {
            if (rnd <= 0x02) rnd = 0x2000000 + (Math.random()*0x1000000)|0;
            r = rnd & 0xf;
            rnd = rnd >> 4;
            uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
          }
        }
        return uuid.join('');
      };
     
      // A more compact, but less performant, RFC4122v4 solution:
      Math.uuidCompact = function() {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
          var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
          return v.toString(16);
        });
      };
    })();

	function GMTtoTime(value){
	    if(value=="" || value==null){
	        return "";
	    }
	    else{
	        var tempValue = value.replace("T", " ");
	        var dateBefore = tempValue.slice(0,10);

	        var timeBefore = tempValue.slice(11,19);
	        var dateArray = dateBefore.split("-");
	        var timeArray = timeBefore.split(":");
	        //注意，Date对象中的getMonth() 返回0~11
	        var feedDate = Date.UTC(dateArray[0],dateArray[1]-1,dateArray[2],timeArray[0],timeArray[1],timeArray[2],0) + 8*60*60;
	        var now = new Date();
	        now.setTime(feedDate);

	        if (now.getMonth()+1 < 10 ){
	            var m=0;
	            m=now.getMonth()+1;
	           // m=now.getMonth();
	            var month = "0" + m;
	        }else{
	            var month = now.getMonth()+1;
	        }

	       //console.log("*** now.getDate()=" + now.getDate() + ",now.getMonth()="+now.getMonth() );

	        if (now.getDate()<10){
	            var d=0;
	            //d=now.getDate()+1;
	            d=now.getDate();

	            var date = "0" + d;
	        }else{
	            var date = now.getDate();
	        }
	        var dateAfter = now.getFullYear() + "-" + month + "-" + date;
	        //                var dateAfter = month + "月" + date + "日";

	        if (now.getHours()<10){
	            var hour = "0" + now.getHours();
	        }else{
	            var hour = now.getHours();
	        }

	        if (now.getMinutes()<10){
	            var minute = "0" + now.getMinutes();
	        }else{
	            var minute = now.getMinutes();
	        }
	        var timeAfter = hour + ":" + timeArray[1]+":"+timeArray[2];

	        var timeFinal = dateAfter + "  " + timeAfter;
	        return timeFinal;
	    }
	}	
