$( "#click-signup" ).click(function() {
    $(".signup-wrapper").addClass('active')
    $(".signin-wrapper").removeClass('active')

    $(".signin-wrapper").addClass('inactive')
    $(".signup-wrapper").removeClass('inactive')
});

$( "#click-signin" ).click(function() {
    $(".signin-wrapper").addClass('active')
    $(".signup-wrapper").removeClass('active')

    $(".signup-wrapper").addClass('inactive')
    $(".signin-wrapper").removeClass('inactive')
});

$("#mobile").click(function(){
    $(".root").addClass('mobile-root')
})

$("#desk").click(function(){
    $(".root").removeClass('mobile-root')
})