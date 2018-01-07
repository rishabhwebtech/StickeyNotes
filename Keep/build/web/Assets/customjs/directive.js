angular.module('myApp').directive('focusScale',[function(){
     
 return{
     
   restrict:'A',
   link:function(scope,element,attr){
       element.focus(function(){
        element.css({'transform':'scale(1.1)'});
       });
      element.focusout(function(){
        element.css({'transform':'scale(1)','-webkit-transform':'rotate(4deg)'});
       });
   }
 };
}]);

angular.module('myApp').directive('focusRotate',['$http',function($http){
        
 return{
     
  restrict:'A',
  link:function(scope,element,attr){
     element.on('dblclick',function(){
         element.attr('contenteditable','true');
         element.css({'-webkit-transform':'rotate(0deg)'});
         element.children().css({'font-family':'arial'});        
     });
     element.on('focusout',function(){
         var values =element.text();
         var parentId=attr.id;
         element.attr('contenteditable','false');
         element.css({'-webkit-transform':'rotate(4deg)'});
        element.children().css({'font-family':'reenie'});
        $http({
       url: "UserAction",
       method: 'POST',
       data: $.param({action:"update",value:values,id:parentId}),
      headers : {'Content-Type':'application/x-www-form-urlencoded; charset=ISO-8859-1'}
      }).then(function(response){
         console.log(response.data);
     });
        
     });
  }
 
 };    
        
}]);

angular.module('myApp').directive('search',[function(){
        
return{
restrict:'E',  
scope:{
    search:'='
},
link:function(scope,element,attr){

}
};        
        
}]);



