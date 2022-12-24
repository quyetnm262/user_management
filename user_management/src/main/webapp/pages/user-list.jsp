<%@ page import="com.jdbcservlet.user_management.entity.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/08/22
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>AdminLTE 3 | Starter</title>

    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="template/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="template/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" data-slide="true" href="${pageContext.request.contextPath}/logout" role="button"><i class="fa-solid fa-right-from-bracket"></i>Đăng xuất</a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="${pageContext.request.contextPath}/admin-home" class="brand-link">
            <img src="template/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar userDto panel (optional) -->
            <div class="userDto-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="template/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">

                    <a href="#" class="d-block">${sessionScope.USER.username }</a>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/admin-user?type=" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>Quản lý người dùng</p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">Quản lý người dùng</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin-home">Home</a></li>
                            <li class="breadcrumb-item active">Quản lý người dùng</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <form id="formSearch">
                        <div class="row" style="margin: 20px">
                            <div class="col-sm-8 col-md-4">
                                <h4>Tên đầy đủ</h4>

                                <div class="color-palette-set">
                                    <input  name="name" class="form-control" id="name" placeholder="Nhập họ và tên">
                                </div>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-8 col-md-4">
                                <h4 >Tuổi</h4>
                                <div class="color-palette-set">
                                    <input  name="age" class="form-control" id="age" placeholder="Nhập tuổi">
                                </div>
                            </div>
                            <!-- /.col -->
                            <div class="col-sm-8 col-md-4">
                                <h4>Nhập tên đăng nhập</h4>
                                <div class="color-palette-set">
                                    <input  name="username" class="form-control" id="username" placeholder="Nhập tên đăng nhập">
                                </div>
                            </div>
                            <div class="col-sm-8 col-md-4">
                                <div class="color-palette-set">
                                    <button type="button" id="seachBtn" class="btn btn-block btn-primary" style="margin-top: 11px;
    width: 54%;">Tìm kiếm</button>
                                </div>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>
                    <div class="col-12">
                        <div class="card">
                            <a class="btn btn-block btn-success btn-xs" href="${pageContext.request.contextPath}/admin-user?type=add" style="
    width: 12%;
    height: 30px;
    text-align: center;
    margin: 19px;
    line-height: 24px
    ">Thêm mới người dùng</a>
                            <div class="card-header">
                                <h3 class="card-title">Danh sách người dùng</h3>

                            </div>
                            <!-- /.card-header -->
                            <div class="card-body table-responsive p-0">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên</th>
                                        <th>Tên đăng nhập</th>
                                        <th>Tuổi</th>
                                        <th>Giới tính</th>
                                        <th>Địa chỉ</th>
                                        <th>Hành động</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                <c:forEach var="user" items="${users}">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.name}</td>
                                        <td>${user.username}</td>
                                        <td>${user.age}</td>
                                        <c:if test="${user.sex == 1}">
                                            <td>Nam</td>
                                        </c:if>
                                        <c:if test="${user.sex == 2}">
                                            <td>Nữ</td>
                                        </c:if>
                                        <td>${user.address}</td>
                                        <td>
                                            <a class="btn btn-block btn-warning btn-xs" href="${pageContext.request.contextPath}/admin-user?type=${user.id}" style="
    width: 28%;
    height: 30px;"><i class="fa-solid fa-pen-to-square"></i>

                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col-md-6 -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
        <div class="p-3">
            <h5>Title</h5>
            <p>Sidebar content</p>
        </div>
    </aside>
    <!-- /.control-sidebar -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="float-right d-none d-sm-inline">
            Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2014-2019 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="template/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="template/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="template/dist/js/adminlte.min.js"></script>
<script src="https://kit.fontawesome.com/cd553914f6.js" crossorigin="anonymous"></script>
<script>
    // http://localhost:8080/user/api?name=&username=admin&age=30
    $("#seachBtn").click(function (){
        let arr= $("#formSearch").serializeArray();
        console.log(arr);
        let param = {};
        for(let i=0;i< arr.length;i++){
            param[arr[i].name] = arr[i].value;
        }
        console.log(param)
        $.ajax({
            url: "http://localhost:8080/user/api",
            type: 'GET',
            data: param,
            success: function (response){
                console.log(response);
                render(response.data);
            },
            error: function (error){
                console.log(error);
            }
        });
        function render(arr) {
            $('table > tbody').empty();
            for (let i = 0; i < arr.length; i++) {
                var sex;
                if (arr[i].sex === 1) sex = "Nam";
                else sex = "Nữ";
                var contentRow = '<tr>\n' +
                    '   <td>'+arr[i].id+'</td>\n' +
                    '   <td>'+arr[i].name+'</td>\n' +
                    '   <td>'+arr[i].username+'</td>\n' +
                    '   <td>'+arr[i].age+'</td>\n' +
                    '   <td>'+sex+'</td>\n' +
                    '   <td>'+arr[i].address+'</td>\n' +
                    '   <td><a class="btn btn-block btn-warning btn-xs" href="/admin-user?type='+arr[i].id +'" style= " width: 28%; height: 30px;"><i class="fa-solid fa-pen-to-square"></i></a></td>\n' +
                    '</tr>';
                $('table > tbody').append(contentRow);
            }
        }
    })
</script>
</body>
</html>
