 $(document).ready(function(){
        $("#a1").click(function(){
            $(this).hide();
        });
		$("#a2").click(function(){
		if($("#a4").length>0)
        {
       window.Android.showToast();
        }

        });
		$("#a3").click(function(){
            console.log("已在studio的控制台上打印了log");
        });
    });