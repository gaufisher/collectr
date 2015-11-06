/**
 * Created by ddelaney on 11/4/2015.
 */
$(document).ready(function(){
    $("#addCollectibleButton").click(function(){
        $("#newCollectibleForm").css("display", "block");
        $("#fade").css("display", "block");
    });

    //Add categories to dropdown
    $.ajax({
        url: "/category",
        method: "GET"
    }).then(function(categories){
        addDropdown($("#typeDropdown").html(), $("#typeSelection"), categories)
    });

    //Add color to dropdown
    $.ajax({
        url: "/color",
        method: "GET"
    }).then(function(colors){
        addDropdown($("#colorDropdown").html(), $("#colorSelection"), colors);
    });

    //Add conditions to dropdown
    $.ajax({
        url: "/conditions",
        method: "GET"
    }).then(function(conditions){
        addDropdown($("#conditionDropdown").html(), $("#conditionSelection"), conditions);
    });

    //Add age to dropdown
    $.ajax({
        url: "/agetypes",
        method: "GET"
    }).then(function(age){
        addDropdown($("#ageDropdown").html(), $("#ageSelection"), age);
    });

    // Removes popup from display when users clicks away from container.
    $(document).mouseup(function (e) {
        var container = $("#newCollectibleForm");

        if (!container.is(e.target)
            && container.has(e.target).length === 0)
        {
            $("#newCollectibleForm").css("display", "none");
            $("#fade").css("display", "none");
        }
    });

    $("#cancelAdd").click(function(){
        $("#newCollectibleForm").css("display", "none");
        $("#fade").css("display", "none");
    });

    $("#submitAdd").click(function(){
        var isValid = true; // Set to true for testing. TODO: Change to false for production.
        var collectible = {};

        if (isValid){
            $.ajax({
                url: '/collectibles',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(collectible)
            }).then(function(){
                console.log("Post successful")
            }, function(error){
                console.log(error);
            });
        }
    });

    $("#typeSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputType").val(text);
    });

    $("#colorSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputColor").val(text);
    });

    $("#conditionSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputCondition").val(text);
    });

    $("#ageSelection").find("li").click(function () {
        var text = $(this).text();
        $("#inputAge").val(text);
    });

    keywords();

});

function addDropdown (source, destination, object){
    var template = Handlebars.compile(source);
    destination.html(template(object));
}

function keywords () {
    $('#keywords input').on('focusout',function(){
        var txt= this.value.replace(/[^\w ]/g,'');
        if(txt) {
            $(this).before('<span class="keywords">'+ txt.toLowerCase() +'</span>');
        }
        this.value="";
    }).on('keyup',function( e ){
        // if: comma,enter (delimit more keyCodes with | pipe)
        if(/(188|13)/.test(e.which)) $(this).focusout();

    });


    $('#keywords').on('click','.keywords',function(){
        $(this).remove();
    });
}