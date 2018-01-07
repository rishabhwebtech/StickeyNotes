function editAndUpdate(primaryId){
$(primaryId).attr('contenteditable','true');  
$(primaryId).css({"font-family":"Arial","-webkit-transform":"rotate(0deg)"});
$(primaryId).on('blur',function(){alert();});
}