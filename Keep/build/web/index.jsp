<%-- 
    Document   : index
    Created on : Oct 12, 2016, 7:38:34 PM
    Author     : Rishabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="myApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Assets/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Assets/customcss/custom.css" rel="stylesheet" type="text/css"/>
        <link href="Assets/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="Assets/customcss/animate.css" rel="stylesheet" type="text/css"/>
        <script src="Assets/jquery/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="Assets/angular/angular.min.js" type="text/javascript"></script>
        <script src="Assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="Assets/customjs/app.js" type="text/javascript"></script>
        <script src="Assets/customjs/directive.js" type="text/javascript"></script>
        <script src="Assets/customjs/controller.js" type="text/javascript"></script>
        <script src="Assets/customjs/javaS.js" type="text/javascript"></script>
        <title>Keep</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page import="java.util.Random" %>
    </head>
    <body ng-controller="displayCtrl">
        <%
        String color[]={"#CCCCFF","#CCFFCC","#FFFFCC"};
        Random rand=new Random();
        int index=rand.nextInt(3);
        String newColor=color[index];
        %>
        <nav class="navbar navbar-default navbar-fixed-top"> 
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-target="#mycollapse" data-toggle="collapse"><span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">
                        <span class="white-text">Notes</span>
                    </a>
                </div>
                    <div class="navbar-collapse collapse" id="mycollapse">
                        <ul class="nav navbar-nav">
                            <li><input type="text" class="form-control" search/></li>
                        </ul>
                        <ul  class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="white-text">Notes Search</span></a></li>
                        <li><input type="text" class="form-control" ng-model="search"><span class="fa fa-search search"></span></li>
                        </ul>
                    </div>
            </div>         
        </nav>
        
        
        <div class="container">
             <div class="row" style="margin-top: 6%;">
            <div ng-controller="getDataOrSetCtrl">
 
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="a">
                   
                    <div class="box z-depth-2"  focus-scale id="b"   ng-blur="save('b','a',parent)" contenteditable="true">
                      
                    </div>
                </div>
          </div>
      <div id='append'></div>
       <div  ng-repeat="p in boxdata|filter:search" id={{p.iddiv}}>
       <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" class="boxes"  >
        <span class="close" ng-click="deleteData(p.iddiv)">X</span>
        <div class="box z-depth-2"  ng-blur="update(p.iddiv)" focus-rotate style="background-color:<%=newColor%>">
                    <p id={{p.iddiv}}>  {{p.text}}</p>
        </div>    
        </div>
     
        </div>
            
         </div>
        </div>
      
         <nav class="navbar navbar-default navbar-fixed-bottom">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                        <li><a href="#"><span class="white-text">@Author : Rishabh Singh</span></a></li>
                </ul>    
            </div>
        </nav>
    </body>
</html>
