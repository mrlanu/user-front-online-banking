
$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click',function(event){
        event.preventDefault();
        $('.myForm #recipientModal').modal();
    });

});

