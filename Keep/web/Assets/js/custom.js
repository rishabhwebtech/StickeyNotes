$(document).ready(function(){

setInterval(function(){
    var date=new Date();
$('#timer').text(date.getHours()+":"+date.getMinutes()).css({'color':'white'});    
    
},0);    
    
});