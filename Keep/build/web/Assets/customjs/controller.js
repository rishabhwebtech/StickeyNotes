angular.module('myApp').controller('getDataOrSetCtrl',['$http','$scope','$compile',function($http,$scope,$compile){
        var idhtml=0;
        $scope.save=function(event){
          var color=["#CCCCFF","#CCFFCC","#FFFFCC"];  
          var index=Math.floor(Math.random()*2+1);
          console.log(index);
          var newcolor=color[index];
         var element=angular.element(document.getElementById(event));
         var values=element.text();
         element.text("");
         idhtml=idhtml+1; 
       //  pare.addClass("animated bounceIn");
       $http({
       url: "UserAction",
       method: 'POST',
       data: $.param({action:"save",value:values,id:idhtml}),
       headers : {'Content-Type':'application/x-www-form-urlencoded; charset=ISO-8859-1'}
       }).then(function(response){
       var data=angular.fromJson(response.data);
       var idOfBox=data[0].idOfBox;
       console.log(idOfBox);
       var mainText=data[0].mainText;
       console.log(mainText);
       var pare=angular.element(document.getElementById('append'));
       var htmls="<div class='col-lg-4 col-md-4 col-sm-4 col-xs-12 animated fadeIn'   id='"+idOfBox+"'><span class='close' ng-click='deleteData("+idOfBox+")'>X</span><div class='box z-depth-2' focus-rotate  id='"+idOfBox+"' style='background-color:"+newcolor+"'><p >"+mainText+"</p></div></div>";
       var compilehtml=$compile(htmls)($scope);
       pare.append(compilehtml);
       },function(response){
         console.log("ERROR");
       });
       };
    
     
}]);



  angular.module('myApp').controller('displayCtrl',['$scope','$http',function($scope,$http){
  $scope.deleteData=function(id){      
   var element=angular.element(document.getElementById(id));
   element.addClass("animated fadeOut");
   element.one('webkitTransitionEnd moztransitionend transitionend oTransitionEnd',function(){
      element.remove();
      });
      $http({
        url: "UserAction",
        method: 'POST',
        data:$.param({action:"delete",id:id}),
        headers : {'Content-Type':'application/x-www-form-urlencoded; charset=ISO-8859-1'}
        }); 
  };
      
      
        $http({
        url: "UserAction",
        method: 'POST',
        data:$.param({action:"get"}),
        headers : {'Content-Type':'application/x-www-form-urlencoded; charset=ISO-8859-1'}
        }).then(function(response){
       
         var data=angular.fromJson(response.data);
           console.log("response "+data.text);
         $scope.boxdata=data;
      
       });
      
$scope.update=function(parentId){
    var element=angular.element(document.getElementById(parentId));
           var values=element.text();

       $http({
       url: "UserAction",
       method: 'POST',
       data: $.param({action:"update",value:values,id:parentId}),
      headers : {'Content-Type':'application/x-www-form-urlencoded; charset=ISO-8859-1'}
      }).then(function(response){
         console.log(response.data);
     });
};
$scope.editAndUpdate=function(primaryId){
         var element=angular.element(document.getElementById(primaryId));
         element.attr('contenteditable','true');  
         };
}]);


