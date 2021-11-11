<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/header.css">
<link rel="stylesheet" href="../../resources/css/style-main.css">
<script src="https://kit.fontawesome.com/9f5e8136b5.js"></script>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<div>
<jsp:include page="../sidebar/sidebar-service-manager.jsp"></jsp:include>
<form action="#" method="get" class="float-left main-content border-top" id="form-update-employee">
            <h2 class="m-4">Edit Parking lot</h2>
            <hr class="m-4">
            
            <input type="hidden" name="id" value="" id="id">

            <table class="m-4">
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Parking name <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter parking name" type="text"
                            name="parkingname" id="parkingname" required></td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Place <label class="required">(*)</label></td>
                    <td>
                        <select name="department" class="box form-control pt-2 pb-2 text-sm">
                            <option value="Khu Đông" selected>Khu Đông</option>
                            <option value="Khu Tây">Khu Tây</option>
                            <option value="Khu Nam">Khu Nam</option>
                            <option value="Khu Bắc">Khu Bắc</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Area <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter area" type="number"
                            name="area" id="area" min="1" required></td>
                            <td class="font-weight-bold pl-4">(m2)</td>
                </tr>
                <tr>
                    <td class="font-weight-bold pr-5 pt-2 pb-2">Price <label class="required">(*)</label></td>
                    <td><input class="box form-control pt-2 pb-2 text-sm" placeholder="Enter price" type="number"
                            name="price" id="price" min="1" required></td>
                            <td class="font-weight-bold pl-4">(VNĐ)</td>
                </tr>
            </table>
            <div class="d-flex list-btn">
                <div  onclick="window.history.back();" class="btn btn-info mr-1 text-btn"><i class="fas fa-backward mr-1"></i>Back</div>
                <div onclick="clickReset()" class="btn btn-warning mr-1 text-btn"><i class="fas fa-redo mr-1" style="transform: scaleX(-1);"></i>Reset</div>
                <button class="btn btn-success mr-1 text-btn">
                    <i class="fas fa-plus mr-1"></i>Update
                </button>
            </div>
        </form>
</div>
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../resources/js/validate-add-parking-lot.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
</body>
</html>