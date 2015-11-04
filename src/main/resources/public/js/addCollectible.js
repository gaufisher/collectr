/**
 * Created by ddelaney on 11/4/2015.
 */
$(document).ready(function(){
    $("#addCollectibleButton").click(function(){
        $("#newCollectibleForm").css("display", "block");
        $("#fade").css("display", "block");
    });

    $(document).mouseup(function (e)
    {
        var container = $("#newCollectibleForm");

        if (!container.is(e.target) // if the target of the click isn't the container...
            && container.has(e.target).length === 0) // ... nor a descendant of the container
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
        var collectible = {};

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
    });
});