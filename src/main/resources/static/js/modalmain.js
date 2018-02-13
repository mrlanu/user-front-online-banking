/**
 *
 */

$(document).ready(function(){

    $('.nBtn, .table .eBtn').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text=='Edit'){
            $.get(href, function(recipient,status){
                document.getElementById("recipientModalLabel").innerHTML = 'Edit recipient: ' + recipient.name;
                $('.myForm #id').val(recipient.id);
                $('.myForm #name').val(recipient.name);
                $('.myForm #email').val(recipient.email);
                $('.myForm #phone').val(recipient.phone);
                $('.myForm #accountNumber').val(recipient.accountNumber);
                $('.myForm #description').val(recipient.description);
            });
            $('.myForm #recipientModal').modal();
        }else{
            document.getElementById("recipientModalLabel").innerHTML = 'New recipient';
            $('.myForm #id').val('');
            $('.myForm #name').val('');
            $('.myForm #email').val('');
            $('.myForm #phone').val('');
            $('.myForm #accountNumber').val('');
            $('.myForm #description').val('');
            $('.myForm #recipientModal').modal();
        }
    });

    $('.table .delBtn').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href',href);
        $('#myModal').modal();
    });
});