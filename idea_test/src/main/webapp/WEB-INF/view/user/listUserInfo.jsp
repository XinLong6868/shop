<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
    <jsp:include page="/WEB-INF/common/head.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <%--ztree树状图+有关产品--%>
        <div class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    部门管理
                    <button type="button" class="btn btn-info" onclick="addShowDept();">
                        <span class="glyphicon glyphicon-plus">添加节点</span>
                    </button>
                    <button type="button" class="btn btn-info" onclick="showEditDialog();">
                        <span class=" glyphicon glyphicon-pencil">修改节点</span>
                    </button>
                    <button type="button" class="btn btn-info" onclick="deleteDeptInfo();">
                        <span class=" glyphicon glyphicon-trash">删除节点</span>
                    </button>
                </div>

                <div class="panel-body">
                    <ul id="deptDemo" class="ztree"></ul>
                </div>
            </div>
        </div>
        <%--标题+条件查询+表单+按钮--%>
        <div class="col-md-9">
            <%--标题内容--%>
            <div class="panel-heading" style="background-color:pink">
                <h2>飞狐电商用户管理</h2>
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="#">登录人:<b>${userInfo.userName}</b>,您好！欢迎登陆！！</a>
                    </li>
                    <li role="presentation">
                        <a href="#">本次登陆次数：${userInfo.loginCount}</a>
                    </li>
                    <li>
                        <a href="#">上次登录时间:<fmt:formatDate value="${userInfo.lastLoginTime}" type="both"/></a>
                    </li>
                    <li role="presentation"><a href="<%=request.getContextPath()%>/brand/listBrand.action">品牌管理</a></li>
                    <li role="presentation"><a href="<%=request.getContextPath()%>/user/tolistUserInfo.action">用户管理</a>
                    </li>
                    <li role="presentation"><a href="<%=request.getContextPath()%>/log/listLogInfo.action">日志管理</a></li>
                </ul>
            </div>
            <%--表单条件查询--%>
            <div class="panel panel-default">
                <%--条件查询表单--%>
                <form class="form-horizontal" id="productForm">
                    <%--商品名称查询--%>
                    <div class="form-group">
                        <label for="productName" class="col-md-4 control-label">商品查询:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control" id="productName" placeholder="请选择要查询的商品">
                        </div>
                    </div>
                    <%--商品品牌查询--%>
                    <div class="form-group">
                        <label for="brandSelect" class="col-md-4 control-label">商品品牌查询:</label>
                        <div class="col-md-4">
                            <select class="form-control" id="brandSelect" name="brandText.id">
                                <option value="-1">==请选择==</option>
                            </select>
                        </div>
                    </div>
                    <%--商品价格区间查询--%>
                    <div class="form-group">
                        <label class="col-md-4 control-label">商品价格区间查询:</label>
                        <div class="col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="查询商品的最低价格" id="minprivace">
                                <span class="input-group-addon" id="basic-addon1">
                         <i class="glyphicon glyphicon-jpy"></i>
                         </span>
                                <input type="text" class="form-control" placeholder="查询商品的最高价格" id="maxprivace">
                            </div>
                        </div>
                    </div>
                    <%--商品时间区间查询--%>
                    <div class="form-group">
                        <label class="col-md-4 control-label">商品时间区间查询:</label>
                        <div class="col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="查询商品的最早出产期" id="minupdateTime">
                                <span class="input-group-addon" id="basic-addon2">
                         <i class="glyphicon glyphicon-dashboard"></i>
                         </span>
                                <input type="text" class="form-control" placeholder="查询商品的晚出产日期" id="maxupdateTime">
                            </div>
                        </div>
                    </div>
                    <%--表单按钮查询--%>
                    <div class="clearfix form-actions" style="text-align:center">
                        <button class="btn btn-primary" type="button" onclick="search()">
                            <i class="glyphicon glyphicon-ok"></i>
                            查询
                        </button>
                        <button class="btn btn-default" type="reset">
                            <i class="glyphicon glyphicon-refresh"></i>
                            重置
                        </button>
                    </div>
                </form>
                <%--添加操作按钮--%>
                <div style="background:#d8d8d8;text-align:right;">
                    <button type="button" class="btn btn-info" onclick="addBatchUser();">
                        <span class="glyphicon glyphicon-plus"></span>
                        添加用户
                    </button>

                    <button type="button" class="btn btn-danger">
                        <span class="glyphicon glyphicon-remove" onclick="deleteBatchProduct();"></span>
                        批量删除
                    </button>

                    <button type="button" class="btn btn-danger">
                        <span class="glyphicon glyphicon-download-alt" onclick="exportExcel();">导出Excel</span>
                    </button>
                </div>
                <%--表格--%>
                <table id="userInfoTable" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                    <tr>
                        <th>选择</th>
                        <th>编号</th>
                        <th>用户名称</th>
                        <th>用户真实姓名</th>
                        <th>用户性别</th>
                        <th>用户工资</th>
                        <th>用户生日</th>
                        <th>用户所在部门</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>选择</th>
                        <th>编号</th>
                        <th>用户名称</th>
                        <th>用户真实姓名</th>
                        <th>用户性别</th>
                        <th>用户工资</th>
                        <th>用户生日</th>
                        <th>用户所在部门</th>
                        <th>操作</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>
<%--要增加ztree的弹出框--%>
<div id="addDeptInfoDialog" style="display:none;">
    <div class="panel panel-default">
        <form class="form-horizontal">
            <%--选中部门的Id--%>
            <input type="text" id="pid"/>
            <div class="form-group">
                <label for="deptName" class="col-md-4 control-label">部门名:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="deptName" placeholder="请选择要添加的部门名">
                </div>
            </div>
            <div class="form-group">
                <label for="remark" class="col-md-4 control-label">部门描述:</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="remark" placeholder="请对您要添加的部门进行简要描述"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>
<%--要修改ztree的弹出框--%>
<div id="editDeptInfoDialog" style="display:none;">
    <div class="panel panel-default">
        <form class="form-horizontal">
            <%--选中部门的Id--%>
            <input type="text" id="edit_id"/>
            <div class="form-group">
                <label for="edit_deptName" class="col-md-4 control-label">部门名:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="edit_deptName" placeholder="请选择要修改的部门名">
                </div>
            </div>
            <div class="form-group">
                <label for="edit_remark" class="col-md-4 control-label">部门描述:</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="edit_remark" placeholder="请对您要修改的部门进行简要描述"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>
<%--要增加的用户--%>
<div id="addUserDialog" style="display: none">
    <form class="form-horizontal">
        <%--用户名称增加--%>
        <div class="form-group">
            <label for="userName" class="col-md-4 control-label">用户增加</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="userName" placeholder="用户名">
            </div>
        </div>
            <%--密码--%>
            <div class="form-group">
                <label class="col-md-4 control-label">用户密码</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="userPwd" placeholder="用户密码">
                </div>
            </div>
            <%--确认密码--%>
            <div class="form-group">
                <label class="col-md-4 control-label">用户确认密码</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="confirmPwd" placeholder="确认用户密码">
                </div>
            </div>
        <%--用户名称增加--%>
        <div class="form-group">
            <label for="userRealName" class="col-md-4 control-label">用户真实姓名增加</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="userRealName" placeholder="用户真实姓名">
            </div>
        </div>
            <%--用户性别增加--%>
            <div class="form-group">
                <label class="col-md-4 control-label">用户性别</label>
                <div class="col-md-4">
                    <input type="radio" name="sex" value="1">男
                    <input type="radio" name="sex" value="0">女
                </div>
            </div>
            <%--用户薪资--%>
            <div class="form-group">
                <label class="col-md-4 control-label">用户薪资</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="salary" placeholder="用户薪资">
                </div>
            </div>
            <%--用户生日--%>
            <div class="form-group">
                <label class="col-md-4 control-label">用户生日</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="birthday" placeholder="生日">
                </div>
            </div>

            <%--用户所在部门--%>
            <div class="form-group">
                <label class="col-md-4 control-label">部门</label>
                <div class="col-md-4">
                    <div class="input-group">
                        <input type="hidden" class="form-control" id="deptId" >
                        <input type="text" class="form-control" id="deptNameInfo" placeholder = "部门">
                        <span class="input-group-btn">
                        <button class="btn btn-primary" type="button" onclick="showDeptTreeDialog()">选择要添加的部门</button>
                        </span>
                    </div>
                </div>
            </div>
    </form>
</div>

<div id="treeDialog" style="display: none">
    <ul id="deptInfoDemo" class="ztree"></ul>
</div>
</body>
    <jsp:include page="/WEB-INF/common/script.jsp"></jsp:include>
<script>
    $(function () {
        //初始化部门表
        innitDeptTree();
        //初始化用户表
        innitUserTable();
        innitBindEvent();

    })
    function showDeptTreeDialog() {
        //获取原有数据
        var v_source = $("#treeDialog").html();
        $.ajax({
            type: "post",
            url: "<%=request.getContextPath()%>/dept/findList.action",
            success: function (result) {
                //进行与ztree有关的setting配置
                var setting = {
                    data: {
                        simpleData: {
                            enable: true,
                            pIdKey: "pid"
                        },
                        key: {
                            name: "deptName"
                        }
                    }
                };
                if (result.code == 200) {
                    //渲染ztree
                    $.fn.zTree.init($("#deptInfoDemo"), setting, result.data);
                    //弹出对话框
                    bootbox.dialog({
                        message: $("#deptInfoDemo"),
                        size: "large",
                        title: "选择部门:",
                        buttons: {
                            confirm: {
                                label: '<span class="glyphicon glyphicon-ok">确认</span>',
                                className: 'btn-success',
                                callback: function () {
                                    //获取当前选中节点的集合
                                    var treeObj = $.fn.zTree.getZTreeObj("deptInfoDemo");
                                    var nodes = treeObj.getSelectedNodes();
                                    if(nodes.length == 1){
                                        var v_dept = nodes[0].id;
                                        var v_deptName = nodes[0].deptName;
                                        //回填到用户对话框中的指定元素
                                        $("#deptNameInfo",v_addUserDialog).val(v_deptName);
                                        $("#deptId",v_addUserDialog).val(v_dept);
                                    }else {
                                        bootbox.alert({
                                            message: "<span class='glyphicon glyphicon-exclamation-sign'></span>添加部门",
                                            size: "small",
                                            title: "提示信息:"
                                        });
                                    }
                                }
                            },
                            cancel: {
                                label: '<span class="glyphicon glyphicon-remove">取消</span>',
                                className: 'btn-danger',
                            }
                        },
                    });
                    //数据回填
                    $("#treeDialog").html(v_source);
                } else {
                    bootbox.alert({
                        message: "",
                        size: "small",
                        title: "确认删除信息:"
                    });
                }

            }
        });
    }
    //用户表格
    function innitUserTable() {
        productTable = $('#userInfoTable').DataTable({
            //默认排序
            "order": [],
            "aoColumnDefs": [{
                "bSortable": false,
                "aTargets": [0, 1, 2, 3, 4,7,8]
            }],
            "processing": true,
            "serverSide": true,
            "searching": false,
            "lengthMenu": [5, 15, 35],//设置每页条数
            "ajax": {
                "url": "<%=request.getContextPath()%>/user/listUserInfo.action",
                "type": "POST",
                "dataSrc":function (result) {
                    if (result.code == 200){
                        result.draw = result.data.draw;
                        result.recordsTotal = result.data.recordsTotal;
                        result.recordsFiltered = result.data.recordsFiltered;
                        return result.data.data;
                    }
                }
            },
            "drawCallback": function () {
                //获取表格中复选框的值
                $("#userInfoTable tbody tr input[type='checkbox']").each(function () {
                    var v_ids = $(this).val();
                    //把当前值和数组值进行对比,如果一致则进行回填
                    if (isExist(v_ids)) {
                        $(this).closest("tr").css("background", "pink");
                        this.checked = true;
                    }
                })
            },
            "columns": [
                /*复选框*/
                {
                    "data": "id",
                    render: function (d, x, z, y) {
                        return "<input type='checkbox' value='" + d + "' style='width:80px;height: 20px;'/>";
                    }
                },
                {"data": "id"},
                {"data": "userName"},
                {"data": "userRealName"},
                {
                    "data": "sex",
                    render: function (d) {
                        if(d == '1'){
                            return "男";
                        }else{
                            return "女";
                        }
                    }
                },
                {"data": "salary"},
                {"data": "birthday"},
                {"data": "deptName"},
                /*按钮增删改*/
                {
                    "data": "id",
                    render: function (data) {
                        var buttons = '';
                        buttons += '<div class="btn-group">'
                        buttons += '<button class="btn btn-xs btn-info" onclick="toUpdateProduct(' + data + ')">'
                        buttons += '<span class="glyphicon glyphicon-pencil"></span>修改</button>'

                        buttons += '<button class="btn btn-xs btn-danger" onclick="deleteAjax(' + data + ')">'
                        buttons += '<span class="glyphicon glyphicon-remove"></span>删除</button>'

                        buttons += '<button class="btn btn-xs btn-info" onclick="viewChildImage(' + data + ')">'
                        buttons += '<span class="glyphicon glyphicon-pencil"></span>查看子图</button>'
                        buttons += '</div>'
                        return buttons;
                    }
                }

            ],
            /*汉化*/
            "oLanguage": {
                "sLengthMenu": "每页展示 _MENU_条结果",
                "sLoadingRecords": "正在加载.....",
                "sInfo": "显示当前 _START_页;每页 _END_ 条数据，共 _TOTAL_条数据！",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
            }
        });
    }
    /**
     * 树状图列表展示
     */
    function innitDeptTree() {
        //进行与ztree有关的setting配置
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    pIdKey: "pid"
                },
                key: {
                    name: "deptName"
                }
            }
        };
        //ztree展示的数据
        //发送ajax请求
        $.ajax({
            type: "post",
            url: "<%=request.getContextPath()%>/dept/findList.action",
            success: function (result) {
                if (result.code == 200) {
                    //渲染ztree
                    $.fn.zTree.init($("#deptDemo"), setting, result.data);
                } else {
                    bootbox.alert({
                        message: "",
                        size: "small",
                        title: "确认删除信息:"
                    });
                }

            }
        });
    }

    /**
     * 增加选中节点的子节点
     */
    function addShowDept() {
        //获取当前选中节点的集合
        var treeObj = $.fn.zTree.getZTreeObj("deptDemo");
        var nodes = treeObj.getSelectedNodes();
        if (nodes.length == 1) {
            var v_selectNode = nodes[0];
            $("#pid").attr("value", v_selectNode.id);
            var v_addDeptInfoDialog = bootbox.dialog({
                message: $("#addDeptInfoDialog").html(),
                size: "large",
                title: "确认增加信息:",
                buttons: {
                    confirm: {
                        label: '<span class="glyphicon glyphicon-ok">确认</span>',
                        className: 'btn-success',
                        callback: function () {
                            var v_deptName = $("#deptName", v_addDeptInfoDialog).val();
                            var v_pid = $("#pid", v_addDeptInfoDialog).val();
                            var v_remark = $("#remark", v_addDeptInfoDialog).val();
                            //将上述参数放入数组中
                            var v_param = {};
                            v_param.deptName = v_deptName;
                            v_param.pid = v_pid;
                            v_param.remark = v_remark;
                            $.ajax({
                                type: "post",
                                url: "<%=request.getContextPath()%>/dept/addListDeptInfo.action",
                                data: v_param,
                                success: function (result) {
                                    if (result.code == 200) {
                                        //成功后，获得指定节点下的节点
                                        var treeObj = $.fn.zTree.getZTreeObj("deptDemo");
                                        var node = {};
                                        node.deptName = v_deptName;
                                        node.remark = v_remark;
                                        node.id = result.data;
                                        treeObj.addNodes(v_selectNode, node);
                                    } else {
                                        bootbox.alert({
                                            message: "",
                                            size: "small",
                                            title: "确认添加信息:"
                                        });
                                    }
                                }
                            });
                        }
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove">取消</span>',
                        className: 'btn-danger'
                    }
                },
            });
        } else {
            bootbox.alert({
                message: "请选择一个部门",
                size: "small",
                title: "确认添加信息:"
            });
        }

    }

    /**
     * 增加用户
     */
    var v_addUserDialog;
    function addBatchUser() {
        var v_source = $("#addUserDialog").html();
        v_addUserDialog = bootbox.dialog({
            message: $("#addUserDialog form").clone(),
            size: "large",
            title: "确认增加信息:",
            buttons: {
                confirm: {
                    label: '<span class="glyphicon glyphicon-ok">确认</span>',
                    className: 'btn-success',
                    callback: function () {
                        var v_userName = $("#userName", v_addUserDialog).val();
                        var v_userPwd = $("#userPwd", v_addUserDialog).val();
                        var v_userRealName = $("#userRealName", v_addUserDialog).val();
                        var v_sex = $("input[name='sex']:checked", v_addUserDialog).val();
                        var v_salary = $("#salary",v_addUserDialog).val();
                        var v_birthday = $("#birthday",v_addUserDialog).val();
                        var v_deptId = $("#deptId",v_addUserDialog).val();
                        //将上述参数放入数组中
                        var v_param = {};
                        v_param.userName = v_userName;
                        v_param.userPwd = v_userPwd;
                        v_param.userRealName = v_userRealName;
                        v_param.sex = v_sex;
                        v_param.salary = v_salary;
                        v_param.birthday = v_birthday;
                        v_param.deptId = v_deptId;
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/user/addUser.action",
                            data: v_param,
                            success: function (result) {
                                if (result.code == 200) {
                                    //成功后，获得指定节点下的节点

                                } else {
                                    bootbox.alert({
                                        message: "<span class='glyphicon glyphicon-exclamation-sign'></span>添加用户失败",
                                        size: "small",
                                        title: "确认添加信息:"
                                    });
                                }
                            }
                        });
                    }
                },
                cancel: {
                    label: '<span class="glyphicon glyphicon-remove">取消</span>',
                    className: 'btn-danger',



                }
            },
        });
        $("#addUserDialog").html(v_source);
    }
     /**
     * 删除选中节点下的所有节点
     */
    function deleteDeptInfo() {
        //获取当前选中节点的集合
        var treeObj = $.fn.zTree.getZTreeObj("deptDemo");
        var nodes = treeObj.getSelectedNodes();
        if (nodes.length > 0){
            bootbox.confirm({
                message: "确定要删除这条数据吗？",
                size: "small",
                title: "确认删除信息:",
                buttons: {
                    confirm: {
                        label: '<span class="glyphicon glyphicon-ok">确认</span>',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove">取消</span>',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if (result){
                        var nodeArr = treeObj.transformToArray(nodes);
                        //定义一个空数组
                        var idArr = [];
                        for (var i = 0; i < nodeArr.length; i++) {
                            idArr.push(nodeArr[i].id);
                        }
                        $.ajax({
                            type:"post",
                            url:"<%=request.getContextPath()%>/dept/deleteDeptInfo.action",
                            data:{"ids":idArr},
                            success:function (result) {
                                if (result.code == 200){
                                    for (var i = 0; i < nodeArr.length; i++) {
                                        treeObj.removeNode(nodeArr[i]);
                                    }
                                }
                            }
                        })
                    }
                }
            });
        }else{
            bootbox.alert({
                message: "请选择您要删除的部门",
                size: "small",
                title: "确认删除信息:"
            });
        }
    }

    /**
     * 修改选中的子节点
     */
    function showEditDialog() {
        //获取当前选中节点的集合
        var treeObj = $.fn.zTree.getZTreeObj("deptDemo");
        var nodes = treeObj.getSelectedNodes();
        if (nodes.length == 1) {
            var v_selectNode = nodes[0];
            $("#edit_id").attr("value", v_selectNode.id);
            $("#edit_deptName").attr("value", v_selectNode.deptName);
            $("#edit_remark").html(v_selectNode.remark);
            var v_editDeptInfoDialog = bootbox.dialog({
                message: $("#editDeptInfoDialog").html(),
                size: "large",
                title: "确认修改信息:",
                buttons: {
                    confirm: {
                        label: '<span class="glyphicon glyphicon-ok">确认</span>',
                        className: 'btn-success',
                        callback: function () {
                            var v_edit_deptName = $("#edit_deptName", v_editDeptInfoDialog).val();
                            var v_edit_id = $("#edit_id", v_editDeptInfoDialog).val();
                            var v_edit_remark = $("#edit_remark", v_editDeptInfoDialog).val();
                            //将上述参数放入数组中
                            var v_param = {};
                            v_param.deptName = v_edit_deptName;
                            v_param.id = v_edit_id;
                            v_param.remark = v_edit_remark;
                            $.ajax({
                                type: "post",
                                url: "<%=request.getContextPath()%>/dept/updateListDeptInfo.action",
                                data: v_param,
                                success: function (result) {
                                    if (result.code == 200) {
                                        //成功后，获得指定节点下的节点
                                         var treeObj = $.fn.zTree.getZTreeObj("deptDemo");
                                         var node = {};
                                         node.deptName = v_deptName;
                                         node.remark = v_remark;
                                         treeObj.updateNode(node)
                                    } else {
                                        bootbox.alert({
                                            message: "",
                                            size: "small",
                                            title: "确认修改信息:"
                                        });
                                    }
                                }
                            });
                        }
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove">取消</span>',
                        className: 'btn-danger'
                    }
                },
            });
        } else {
            bootbox.alert({
                message: "请选择一个部门",
                size: "small",
                title: "确认修改信息:"
            });
        }
    }
    var v_ids = [];
    //给productTable下的 tbody下的所有tr添加绑定点击事件
    function innitBindEvent() {
        $("#userInfoTable tbody").on("click", "tr", function () {
            //找到复选框
            var v_checkbox = $(this).find("input[type='checkbox']")[0];
            //判断复选框的状态
            if (v_checkbox.checked) {
                //如果复选框处于选中状态，则消除复选框的选中状态，清除对应的背景色，清除数组中的id
                v_checkbox.checked = false;
                $(this).css("background", "");
                delIds(v_checkbox.value);
            } else {
                //如果复选框没被选中，则添加背景色，并将选中的tr的id添加到数组中
                v_checkbox.checked = true;
                $(this).css("background", "pink");
                //将选中的复选框id放入到数组中
                v_ids.push(v_checkbox.value);
                //查看
                /* console.log(v_ids)*/
            }
        });
    }

    function delIds(id) {
        for (var i = v_ids.length - 1; i >= 0; i--) {
            if (v_ids[i] == id) {
                v_ids.splice(i, 1);
                break;
            }
        }
    }

    function isExist(id) {
        for (var i = 0; i < v_ids.length; i++) {
            if (v_ids[i] == id) {
                return true;
            }
        }
    }

</script>

</html>
