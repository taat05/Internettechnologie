$(document).ready(function(){

    $("#update").hide();


    assignDataToTable();

    $('table').on('click', 'button[id="edit"]', function(e){
       var id = $(this).closest('tr').children('td:first').text();
       var firstname = $(this).closest('tr').children('td:nth-child(2)').text();
       var surname = $(this).closest('tr').children('td:nth-child(3)').text();
       var position = $(this).closest('tr').children('td:nth-child(4)').text();
       var club = $(this).closest('tr').children('td:nth-child(5)').text();

        $("#firstname").val(firstname);
        $("#surname").val(surname);
        $("#position").val(position);
        $("#club").val(club);

        $("#update").show();
        $("#save").hide();

        $("#update").click(function() {


            var jsonVar = {
                name: $("#firstname").val(),
                lastName: $("#surname").val(),
                position: $("#position").val(),
                teamName: $("#club").val()
            };

            $.ajax({
                type:"PUT",
                data: JSON.stringify(jsonVar),
                contentType: "application/json",
                url:"http://localhost:8080/api/player/" + id,
                success: function(data){
                    alertUsing("Edited.", true);
                    $("#update").hide();
                    $("#save").show();
                    $("#firstname").val("");
                    $("#surname").val("");
                    $("#position").val("");
                    $("#club").val("");
                    assignDataToTable();
                },
                error: function(err) {
                    console.log(err);
                    alert(err);
                }

        });

    });

    })

    $("#save").click(function() {

        var jsonVar = {
            name: $("#firstname").val(),
            lastName: $("#surname").val(),
            position: $("#position").val(),
            teamName: $("#club").val()
        };

        $.ajax({
            type:"POST",
            url:"http://localhost:8080/api/player/",
            data: JSON.stringify(jsonVar),
            contentType: "application/json",
            success: function(data){
                assignDataToTable();
            },
            error: function(err) {
                console.log(err);
                alert(err);
            }
        });

    });

    function assignDataToTable() {
        $("#players").empty();
        $.ajax({
          type:"GET",
          contentType: "application/json",
          url:"http://localhost:8080/api/players",
          success: function(data) {
          var rows = "";
            for (let player of data) {
                var newRow = "<tr>";
                newRow += "<td>" + player['id'] + "</td>";
                newRow += "<td>" + player['name'] + "</td>";
                newRow += "<td>" + player['lastName'] + "</td>";
                newRow += "<td>" + player['position'] + "</td>";
                newRow += "<td>" + player['teamName'] + "</td>";
                newRow += "<td><button id='edit' class='btn btn-warning'>Update</button></td>";
                newRow += "</tr>";
                rows += newRow;
            }
                $("#players").html(rows);
          },
          error: function(data) {
            console.log(data);
            }
        });

    }
    $("#filter").click(function() {
        applyFilter();
    });

    function applyFilter(){
        var filter = $("#inpSpielersuche").val();
        $.getJSON("http://localhost:8080/api/players",{"filter":filter})
        .done(handlePlayerListReply);
    }

    function handlePlayerListReply(players){
        //console.log(players);
        $("#players").empty();
        for ( let player of players ) {
            addPlayerToList(player);
        }
    }

    function addPlayerToList( player ){
        var newRow = "<tr>";
        newRow += "<td>" + player['id'] + "</td>";
        newRow += "<td>" + player['name'] + "</td>";
        newRow += "<td>" + player['lastName'] + "</td>";
        newRow += "<td>" + player['position'] + "</td>";
        newRow += "<td>" + player['teamName'] + "</td>";
        newRow += "<td><button id='edit' class='btn btn-warning'>Update</button></td>";
        newRow += "</tr>";
        $("#players").append(newRow);
    }


    function alertUsing(text, flag) {

        var alert = $(".alert");

        if(flag){
            alert.removeClass("alert-danger").addClass("alert-success");
        }else{
            alert.removeClass("alert-success").addClass("alert-danger");

        }

        alert.fadeIn(400);
        alert.css("display", "block");
        alert.text(text);
        setTimeout(function() {
            alert.fadeOut();
        }, 2000);

    }

});