<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value="/bower_components/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/bower_components/metisMenu/dist/metisMenu.min.css"/>" rel="stylesheet">
<link href="<c:url value="/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/dist/css/sb-admin-2.css"/>" rel="stylesheet">
<link href="<c:url value="/bower_components/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/dist/custome.css"/>" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
   function BodyOnload()
	{
		var url = window.location.href;
		if(url != "")
		{
		   var arrUrl = url.split('/');
		   var PageName = arrUrl[arrUrl.length - 1];
		   $('#side-menu a').each(function(index, element) {
				if(element.href.indexOf(PageName) > -1)
				{
					var id = element.id;
					var arrParentId = id.split('_');
					if(arrParentId.length >=2)
					{
						arrParentId.splice(0, 1); 	
						var size = arrParentId.length;
						for(var i=0;i < size;i++)
						{
							var name = arrParentId.join('_');
							MenuSelection(name);
							arrParentId.splice(arrParentId.length - 1, 1); 	
						}
					}
				}
           });
		}	
	}
    function MenuSelection(name)
	{
		if(name != "")
		{		
			var elementMenu = document.getElementsByName(name);
			if(elementMenu != null && elementMenu.length > 0)
			{
				for(var i=0;i< elementMenu.length;i++)
				{
					if(elementMenu[i].tagName == "LI")
					{
						elementMenu[i].className = "active";	
					}
					else if(elementMenu[i].tagName == "UL")
					{
						elementMenu[i].className = elementMenu[i].className + "collapse in";	
					}
				}
			}
		}
	}
    </script>