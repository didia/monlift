 <script type="text/javascript">
$(document).ready(function(){

$("#signup").validate({
rules:{
fname:"required",
lname:"required",
email:{
required:true,
email: true
},
passwd:{
required:true,
minlength: 8
},
conpasswd:{
required:true,
equalTo: "#passwd"
},
gender:"required"
},

errorClass: "help-inline"

});
});
</script>