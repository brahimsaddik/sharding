<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
    <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
    <link rel='stylesheet prefetch'
          href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        #success_message {
            display: none;
        }

        body {
            font-family: "Helvetica Neue", Helvetica, Arial;
            font-size: 14px;
            line-height: 20px;
            font-weight: 400;
            color: #3b3b3b;
            -webkit-font-smoothing: antialiased;
            font-smoothing: antialiased;
            background: #2b2b2b;
        }

        .wrapper {
            margin: 0 auto;
            padding: 40px;
            max-width: 800px;
        }

        .table {
            margin: 0 0 40px 0;
            width: 100%;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
            display: table;
        }

        @media screen and (max-width: 580px) {
            .table {
                display: block;
            }
        }

        .row {
            display: table-row;
            background: #f6f6f6;
        }

        .row:nth-of-type(odd) {
            background: #e9e9e9;
        }

        .row.header {
            font-weight: 900;
            color: #ffffff;
            background: #ea6153;
        }

        .row.green {
            background: #27ae60;
        }

        .row.blue {
            background: #2980b9;
        }

        @media screen and (max-width: 580px) {
            .row {
                padding: 8px 0;
                display: block;
            }
        }

        .cell {
            padding: 6px 12px;
            display: table-cell;
        }

        @media screen and (max-width: 580px) {
            .cell {
                padding: 2px 12px;
                display: block;
            }
        }

    </style>
</head>
<body>
<div class="container">

    <form class="well form-horizontal" action=" " method="post" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>Sharding</legend>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="name" name="first_name" placeholder="Trasnporter Name" class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label">E-Mail</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input id="mail" name="email" placeholder="E-Mail Address" class="form-control" type="text">
                    </div>
                </div>
            </div>


            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Phone #</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                        <input id="phone" name="phone" placeholder="(33) 667293674" class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Address</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                        <input id="address" name="address" placeholder="Address" class="form-control" type="text">
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label">Zip Code</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                        <input id="zipcode" name="zip" placeholder="Zip Code" class="form-control" type="text">
                    </div>
                </div>
            </div>

            <!-- Success message -->
            <div class="alert alert-success" role="alert" id="success_message">Success <i
                    class="glyphicon glyphicon-thumbs-up"></i> Thanks for contacting us, we will get back to you
                shortly.
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button type="submit" name="Call Servlet" id="insert1" onclick="insert()" class="btn btn-warning">
                        Send <span class="glyphicon glyphicon-send"></span></button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</div><!-- /.container -->

</br>
<div class="wrapper">


    <div class="table" id="table1">

    </div>
    <div class="table" id="table2">

    </div>
    <div class="table" id="table3">

    </div>
</div>

<script>
    var url = 'http://localhost:8080';
    var get1 = function () {
        $.ajax({
            type: "GET",
            url: url + "/getTransporter1/",
            data: {'test': 'test'},
            success: function (result) {
                $('#table1').empty();
                $('#table1').append("<div class=\"row header\">" +

                    "            <div class=\"cell\">" +
                    "                Shard one" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "        </div>" +
                    "");
                $('#table1').append("<div class=\"row header\">" +

                    "            <div class=\"cell\">" +
                    "                Name" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Email" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Phone" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Adresse" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Zip Code" +
                    "            </div>" +
                    "        </div>" +
                    "");
                for (var data in result) {

                    $('#table1').append(
                        "        <div class=\"row\">" +
                        "            <div class=\"cell\">" +
                        result[data]['name'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['mail'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['phone'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['address'] +
                        "            </div>" + "            <div class=\"cell\">" +
                        result[data]['zip_code'] +
                        "            </div>" +
                        "        </div>");

                }
                //  getpricing1();
            }
        })
    };
    var get2 = function () {
        $.ajax({
            type: "GET",
            url: url + "/getTransporter2/",
            data: {'test': 'test'},
            success: function (result) {
                $('#table2').empty();
                $('#table2').append("<div class=\"row header green \">" +

                    "            <div class=\"cell\">" +
                    "                Shard two" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "        </div>" +
                    "");
                $('#table2').append("<div class=\"row header green \">" +

                    "            <div class=\"cell\">" +
                    "                Name" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Email" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Phone" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Adresse" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Zip Code" +
                    "            </div>" +
                    "        </div>" +
                    "");
                for (var data in result) {

                    $('#table2').append(
                        "        <div class=\"row\">" +
                        "            <div class=\"cell\">" +
                        result[data]['name'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['mail'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['phone'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['address'] +
                        "            </div>" + "            <div class=\"cell\">" +
                        result[data]['zip_code'] +
                        "            </div>" +
                        "        </div>");

                }
                //        getpricing2();
            }
        })
    };
    var get3 = function () {
        $.ajax({
            type: "GET",
            url: url + "/getTransporter3/",
            data: {'test': 'test'},
            success: function (result) {
                $('#table3').empty();
                $('#table3').append("<div class=\"row header blue\">" +

                    "            <div class=\"cell\">" +
                    "                Shard three" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                " +
                    "            </div>" +
                    "        </div>" +
                    "");
                $('#table3').append("<div class=\"row header blue\">" +

                    "            <div class=\"cell\">" +
                    "                Name" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Email" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Phone" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Adresse" +
                    "            </div>" +
                    "            <div class=\"cell\">" +
                    "                Zip Code" +
                    "            </div>" +
                    "        </div>" +
                    "");
                for (var data in result) {

                    $('#table3').append(
                        "        <div class=\"row\">" +
                        "            <div class=\"cell\">" +
                        result[data]['name'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['mail'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['phone'] +
                        "            </div>" +
                        "            <div class=\"cell\">" +
                        result[data]['address'] +
                        "            </div>" + "            <div class=\"cell\">" +
                        result[data]['zip_code'] +
                        "            </div>" +
                        "        </div>");

                }
                //          getpricing3();
            }
        })
    };



    var insert = function () {
        $.ajax({
            type: "GET",
            url: url + "/insert?nom=" + $('#name').val() + "&adresse=" + $('#address').val() + "&zipcode=" + $('#zipcode').val() + "&phone=" + $('#phone').val() + "&mail=" + $('#mail').val(),
            success: function (result) {
                for (var data in result) {
                }
            }
        })
    };
    document.addEventListener("DOMContentLoaded", function () {
        get1();
        get2();
        get3();
    });
    $(document).ready(function () {
        $('#contact_form').bootstrapValidator({
            // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                first_name: {
                    validators: {
                        stringLength: {
                            min: 2,
                        },
                        notEmpty: {
                            message: 'Please supply your the transporter  name'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'Please supply your email address'
                        },
                        emailAddress: {
                            message: 'Please supply a valid email address'
                        }
                    }
                },
                phone: {
                    validators: {
                        notEmpty: {
                            message: 'Please supply your phone number'
                        },
                        phone: {
                            country: 'FR',
                            message: 'Please supply a vaild phone number with area code'
                        }
                    }
                },
                address: {
                    validators: {
                        stringLength: {
                            min: 8,
                        },
                        notEmpty: {
                            message: 'Please supply your street address'
                        }
                    }
                },
                zip: {
                    validators: {
                        notEmpty: {
                            message: 'Please supply your zip code'
                        },
                        zipCode: {
                            country: 'FR',
                            message: 'Please supply a vaild zip code'
                        }
                    }
                }
            }
        }).on('success.form.bv', function (e) {
            $('#success_message').slideDown({opacity: "show"}, "slow") // Do something ...
            $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function (result) {
                console.log(result);
            }, 'json');
        });
    });
</script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>


</body>
</html>