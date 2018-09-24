<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset="utf-8">
    <title>Call Screen</title>
    <!-- Bootstrap-->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--Icones-->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- CSS -->
    <link href="css/style.css" rel="stylesheet">

    <!--ICONE NA ABA DO NAVEGADOR-->
    <link rel="shortcut icon" href="images/Phone-icon.png" type="image/x-icon" style="width: 1000px;"/>
</head>


<body>
    <!--PAINEL CALL SCREEN-->   

    <center>
        <div class="container ">
            <div class="row ">
                <div class="col-md-6 col-md-offset-3" id="painelPhone">
                    <div class="panel panel-phone " style="border-radius: 20px; width: 360px; height: 600px; position: relative;">
                        <div class="panel-body">
                            <div class="row ">
                                <div class="col-lg-12 ">

                                 <div class="col-lg-12" style="padding-top: 20px;">
                                    <div class="panel-body" style="box-shadow: 1px 2px 3px 0 rgba(0,0,0,.10); background-color: #814CCE; border-radius:10px; width: 300px; height: 500px">

                                        <form id="call-form" action="call" method="post" role="form " style="display: block; ">
                                            <h2>Fazer uma Ligação</h2>
                                            <div class="form-group ">
                                                <input type="number"  name="number" id="number" tabindex="2 " class="form-control " placeholder="Número ">
                                                <br><br>
                                                <a href="">
                                                    <button type="submit" name="call-submit" 
                                                    id="call-submit" tabindex="4 " 
                                                    class="form-control btn btn-call-submit"> 
                                                    <i class="fa fa-3x fa-phone" aria-hidden="true"></i>
                                                </button>   
                                            </a>

                                        </div>
                                    </form>

                                    <div class="col-lg-12" style="padding-top: 30px;">
                                        <div class="panel-body" style="box-shadow: 1px 2px 3px 0 rgba(0,0,0,.10); background-color: #9370DB; border-radius:10px; width: 240px;">
                                            <p><b>${chamada.msg}</b></p>
                                            <div class="card">
                                              <div class="card-body">
                                                <p>Número ${chamada.telefone}<p>
                                                    Origem e destino: ${chamada.identificacao}
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </div>
    </div>
</div>        
</center>

</body>

</html>