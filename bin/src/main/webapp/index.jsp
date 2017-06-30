<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        @import url(http://fonts.googleapis.com/css?family=Patua+One|Open+Sans);
        * {
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
        } 

        body {
            background: #353a40;
        }

        table {
            border-collapse: separate;
            background: #fff;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            -moz-box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
            box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
        }

        thead {
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }

        thead th {
            font-family: 'Patua One', cursive;
            font-size: 16px;
            font-weight: 400;
            color: #fff;
            text-shadow: 1px 1px 0px rgba(0, 0, 0, 0.5);
            text-align: left;
            padding: 20px;
            background-image: url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4gPHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+PGRlZnM+PGxpbmVhckdyYWRpZW50IGlkPSJncmFkIiBncmFkaWVudFVuaXRzPSJvYmplY3RCb3VuZGluZ0JveCIgeDE9IjAuNSIgeTE9IjAuMCIgeDI9IjAuNSIgeTI9IjEuMCI+PHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzY0NmY3ZiIvPjxzdG9wIG9mZnNldD0iMTAwJSIgc3RvcC1jb2xvcj0iIzRhNTU2NCIvPjwvbGluZWFyR3JhZGllbnQ+PC9kZWZzPjxyZWN0IHg9IjAiIHk9IjAiIHdpZHRoPSIxMDAlIiBoZWlnaHQ9IjEwMCUiIGZpbGw9InVybCgjZ3JhZCkiIC8+PC9zdmc+IA==');
            background-size: 100%;
            background-image: -webkit-gradient(linear, 50% 0%, 50% 100%, color-stop(0%, #646f7f), color-stop(100%, #4a5564));
            background-image: -moz-linear-gradient(#646f7f, #4a5564);
            background-image: -webkit-linear-gradient(#646f7f, #4a5564);
            background-image: linear-gradient(#646f7f, #4a5564);
            border-top: 1px solid #858d99;
        }
        thead th:first-child {
            -moz-border-radius-topleft: 5px;
            -webkit-border-top-left-radius: 5px;
            border-top-left-radius: 5px;
        }
        thead th:last-child {
            -moz-border-radius-topright: 5px;
            -webkit-border-top-right-radius: 5px;
            border-top-right-radius: 5px;
        }

        tbody tr td {
            font-family: 'Open Sans', sans-serif;
            font-weight: 400;
            color: #5f6062;
            font-size: 13px;
            padding: 20px 20px 20px 20px;
            border-bottom: 1px solid #e0e0e0;
        }

        tbody tr:nth-child(2n) {
            background: #f0f3f5;
        }

        tbody tr:last-child td {
            border-bottom: none;
        }
        tbody tr:last-child td:first-child {
            -moz-border-radius-bottomleft: 5px;
            -webkit-border-bottom-left-radius: 5px;
            border-bottom-left-radius: 5px;
        }
        tbody tr:last-child td:last-child {
            -moz-border-radius-bottomright: 5px;
            -webkit-border-bottom-right-radius: 5px;
            border-bottom-right-radius: 5px;
        }

        tbody:hover > tr td {
            filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=50);
            opacity: 0.5;
            /* uncomment for blur effect */
            /* color:transparent;
            @include text-shadow(0px 0px 2px rgba(0,0,0,0.8));*/
        }

        tbody:hover > tr:hover td {
            text-shadow: none;
            color: #2d2d2d;
            filter: progid:DXImageTransform.Microsoft.Alpha(enabled=false);
            opacity: 1;
        }

    </style>
</head>
<body>




<input type="button" value="Call Servlet1" name="Call Servlet" id="call1" onclick="get1()"/>
<input type="button" value="Call Servlet2" name="Call Servlet" id="call2" onclick="get2()"/>
<input type="button" value="Call Servlet3" name="Call Servlet" id="call3" onclick="get3()"/>
<div id="output"></div>

<table style="float:left;">
    <tr>
        <th>
            Creation Carrier
        </th>
    </tr>
    <tr>
        <th>
            nom
        </th>
        <th>
            adresse
        </th>
    </tr>
    <tr>
        <th>
            name: <input type="text" id="name">
        </th>
        <th>
            address: <input type="text" id="address">
        </th>
    </tr>
    <tr>
        <th>
            <input type="button" value="Inserer" name="Call Servlet" id="insert1" onclick="insert()"/>
        </th>
    </tr>
</table>

<table style="float:left;">
    <tr>
        <th>
            Creation Carrier Pricing
        </th>
    </tr>
    <tr>
        <th>
            nom
        </th>
        <th>
            adresse
        </th>
    </tr>
    <tr>
        <th>
            name: <input type="text" id="name">
        </th>
        <th>
            address: <input type="text" id="address">
        </th>
    </tr>
    <tr>
        <th>
            <input type="button" value="Inserer" name="Call Servlet" id="insert1" onclick="insert()"/>
        </th>
    </tr>
</table>
</br></br></br></br></br></br>
<div>
    <table id="tblProgs">
        <thead>
        <tr>
            <th>
                Shard 1
            </th>
        </tr>
        <tr>
            <th>
                id
            </th>
            <th>
                nom
            </th>
            <th>
                adresse
            </th>
        </tr>
        </thead>
        <tbody id="body1">
        </tbody>
    </table>

    <table id="tb2Progs">
        <thead>
        <tr>
            <th>
                Shard 2
            </th>
        </tr>
        <tr>
            <th>
                id
            </th>
            <th>
                nom
            </th>
            <th>
                adresse
            </th>
        </tr>
        </thead>
        <tbody id="body2">
        </tbody>
    </table>

    <table id="tb3Progs">
    <thead>
    <tr>
        <th>
            Shard 3
        </th>
    </tr>
    <tr>
        <th>
            id
        </th>
        <th>
            nom
        </th>
        <th>
            adresse
        </th>
    </tr>
    </thead>
    <tbody id="body3">
    </tbody>
</table>
</div>
<script>
var url='http://localhost:5432';
/*var url = 'http://localhost:8080';*/
var get1 = function(){$.ajax({
    type: "POST",
    url: url+"/sharding-1.0/getTransporter/",
    data:{'test':'test'},
    success: function (result) {
        $('#body1').empty();
        for (var data in result) {
            $('#body1').append('<tr><th width="33%">'+result[data]['id']+'</th> ' +
                '<th width="33%">'+result[data]['name']+'</th>' +
                '<th width="33%">'+result[data]['address']+'</th> </tr>');
        }
      //  getpricing1();
    }
})};
    var get2 = function(){$.ajax({
        type: "POST",
        url: url+"/sharding-1.0/getTransporter2/",
        data:{'test':'test'},
        success: function (result) {
            $('#body2').empty();
            for (var data in result) {
                $('#body2').append('<tr><th width="33%">'+result[data]['id']+'</th> ' +
                    '<th width="33%">'+result[data]['name']+'</th>' +
                    '<th width="33%">'+result[data]['address']+'</th> </tr>');
            }
    //        getpricing2();
        }
    })};
    var get3 = function(){$.ajax({
        type: "POST",
        url: url+"/sharding-1.0/getTransporter3/",
        data:{'test':'test'},
        success: function (result) {
            $('#body3').empty();
            for (var data in result) {
                $('#body3').append('<tr><th width="33%">'+result[data]['id']+'</th> ' +
                    '<th width="33%">'+result[data]['name']+'</th>' +
                    '<th width="33%">'+result[data]['address']+'</th> </tr>');
            }
  //          getpricing3();
        }
    })};

/*

var getpricing1 = function(){$.ajax({
    type: "POST",
    url: url+"/sharding/getCarrierPricing1/",
    data:{'test':'test'},
    success: function (result) {
        $('#output').empty();
        for (var data in result) {
            $('#output').append('<tr><th width="33%">'+result[data]['id']+'</th> ' +
                '<th width="33%">'+result[data]['name']+'</th>' +
                '<th width="33%">'+result[data]['address']+'</th> </tr>');
        }
    }
})};
var getpricing2 = function(){$.ajax({
    type: "POST",
    url: url+"/sharding/getCarrierPricing2/",
    data:{'test':'test'},
    success: function (result) {
        $('#output').empty();
        for (var data in result) {
            $('#output').append('<tr><th width="33%">'+result[data]['id']+'</th> ' +
                '<th width="33%">'+result[data]['name']+'</th>' +
                '<th width="33%">'+result[data]['address']+'</th> </tr>');
        }
    }
})};
var getpricing3 = function(){$.ajax({
    type: "POST",
    url: url+"/sharding/getCarrierPricing3/",
    data:{'test':'test'},
    success: function (result) {
        $('#output').empty();
        for (var data in result) {
            $('#output').append('<tr><th width="33%">'+result[data]['id']+'</th> ' +
                '<th width="33%">'+result[data]['name']+'</th>' +
                '<th width="33%">'+result[data]['address']+'</th> </tr>');
        }
    }
})};
*/












    var insert = function(){$.ajax({
        type: "GET",
        url: url+"/sharding-1.0/insert/nom="+$('#name').val()+"&adresse="+$('#address').val(),
        success: function (result) {
            $('#output').empty();
            for (var data in result) {
                $('#output').text('sa a inserre');
            }
        }
    })};
document.addEventListener("DOMContentLoaded", function() {
    get1();
    get2();
    get3();
});

</script>

</body>
</html>