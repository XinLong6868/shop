<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="/js/dataTable/datatables.min.css"/>
    <link rel="stylesheet" type="text/css" href="/js/bootStrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css"/>
    <link href="<%=basePath%>/js/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css"/>
    <%--bootStrap上传--%>
    <link rel="stylesheet" type="text/css" href="/js/bootStrap-fileInput/css/fileinput.min.css"/>
</head>

<body>
<div class="container-fluid" style="padding-left: 0px;">
    <div class="row">
        <%--左边--%>
        <div class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-body" style="background: lightskyblue">
                    部门管理
                    <button type="button" class="btn btn-info btn-xs active" onclick="updateDept();"><span
                            class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                    </button>
                    <button type="button" class="btn btn-info btn-xs active" onclick="showAddDept();"><span
                            class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
                    </button>
                    <button type="button" class="btn btn-danger btn-xs  active" onclick="deleteDept();"><span
                            class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
                    </button>
                </div>
                <div class="panel-footer">
                    <%--ztree--%>
                    <ul id="daptTree" class="ztree"></ul>
                </div>
            </div>
        </div>

        <%--右边--%>
        <div class="col-md-9">
            <div class="container-fluid" class="col-md-8">
                <div class="row">

                    <form class="form-horizontal" id="userForm" method="post">
                        <fieldset>
                            <div style="width: 100%;background: lightskyblue">
                                <legend>用户条件查询</legend>
                            </div>
                            <div class="form-group">
                                <label for="userName" class="col-md-2 control-label">用户名</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="userName" placeholder="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-2 control-label">生日</label>
                                <div class="col-sm-4">
                                    <div class="input-group">
                                        <input type="text" class="input-sm form-control form_datetime"
                                               id="minBirthday"/>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>
                                        </span>
                                        <input type="text" class="input-sm form-control form_datetime"
                                               id="maxBirthday"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label">薪资</label>
                                <div class="col-sm-4">
                                    <div class="input-group">
                                        <input type="text" class="input-sm form-control" id="minSalary"/>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-yen" aria-hidden="true"></span>
                                        </span>
                                        <input type="text" class="input-sm form-control" id="maxSalary"/>
                                    </div>
                                </div>
                            </div>

                        </fieldset>
                        <div style="text-align: center">
                            <button type="button" class="btn btn-primary btn-lg active" onclick="search()"><span
                                    class="glyphicon glyphicon-ok" aria-hidden="true"></span>搜索
                            </button>
                            <button type="button" class="btn btn-default btn-lg active" onclick="cancelSelectedNode();"><span
                                    class="glyphicon glyphicon-refresh" aria-hidden="true"></span>重置
                            </button>
                        </div>
                        <input type="hidden" id="tree_deptIds">
                    </form>
                </div>
            </div>

            <div style="background: darkgrey;text-align: right;margin-top: 25px">
                <button type="button" class="btn btn-info btn-lg active" onclick="addUser();"><span
                        class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加用户
                </button>
                <button type="button" class="btn btn-info btn-lg active" onclick="updateUser();"><span
                        class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改用户
                </button>
                <button type="button" class="btn btn-danger btn-lg active" onclick="deleteBatchUser();"><span
                        class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除用户
                </button>
            </div>
        <%--用户列表展示--%>
            <div class="panel panel-primary">

                <div class="panel-body" style="background: lightskyblue">
                    用户列表
                </div>
                <div class="panel-footer">
                    <table id="userTable" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                        <tr>
                            <th>选择</th>
                            <th>序列</th>
                            <th>用户名</th>
                            <th>用户图像</th>
                            <th>登陆状态</th>
                            <th>真是姓名</th>
                            <th>生日</th>
                            <th>性别</th>
                            <th>薪资</th>
                            <th>所在部门</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>选择</th>
                            <th>序列</th>
                            <th>用户名</th>
                            <th>用户图像</th>
                            <th>登陆状态</th>
                            <th>真是姓名</th>
                            <th>生日</th>
                            <th>性别</th>
                            <th>薪资</th>
                            <th>所在部门</th>
                            <th>操作</th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

<%--添加部门--%>
<div id="addDept" style="display: none">

    <form class="form-horizontal" method="post">
        <input type="text" id="tree_deptIdsfatherId">
        <div class="form-group">
            <label class="col-md-2 control-label">部门名称</label>
            <div class="col-md-4">
                <input type="text" class="form-control" placeholder="text" id="deptName">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">部门描述</label>
            <textarea rows="" cols="" id="remark"></textarea>
        </div>
    </form>
</div>


<%--修改部门--%>
<div id="updateDept" style="display: none">

    <form class="form-horizontal" method="post">
        <input type="hidden" id="update_Id">
        <input type="hidden" id="update_fatherId">
        <div class="form-group">
            <label class="col-md-2 control-label">部门名称</label>
            <div class="col-md-4">
                <input type="text" class="form-control" placeholder="text" id="update_deptName">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">部门描述</label>
            <textarea rows="" cols="" id="update_remark"></textarea>
        </div>
    </form>
</div>

<%--添加用户--%>
<div id="addUser" style="display: none">
    <form class="form-horizontal" method="post">
        <div class="form-group">
            <label class="col-md-2 control-label"> 员工名</label>
            <div class="col-md-4">
                <input type="text" class="form-control" placeholder="admin" id="add_userName">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">密码</label>
            <div class="col-md-4">
                <input type="password" class="form-control" id="add_password" placeholder="password">
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label">员工图像</label>
            <div class="col-md-8">
                <input type="text" id="add_userImagePath">
                <input type="file" name="productImage" id="add_uploadImage"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">真实姓名</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="add_userRealName">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">生日</label>
            <div class="col-md-4">
                <input type="text" class="form-control form_datetime" id="add_birthday">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">性别</label>
            <div class="col-md-4">
                <input type="radio" name="sex" value="1">男
                <input type="radio" name="sex" value="2">女
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">薪资</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="add_salary">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">部门</label>
            <div class="col-md-3">

                <input type="text" class="form-control" id="add_daptName">
                <input type="text" class="form-control" id="add_deptId">
            </div>
            <div class="col-md-2" style="padding: 0px">
                <button type="button" class="btn btn-info dropdown-toggle active" onclick="showDeptZtree(v_AddUserDialog,'add_daptName','add_deptId');"><span
                        class="glyphicon glyphicon-refresh" aria-hidden="true"></span>选择
                </button>
            </div>


        </div>
    </form>
</div>

<%--添加和修改用户时选择的部门ztree--%>
<div class="panel-footer" id="deptTreeDiv"  style="display: none">
    <ul id="daptTree2" class="ztree"></ul>
</div>

<%--修改用户--%>




<script type="text/javascript" src="<%=basePath %>/js/jquery.1.9.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5.js"></script>
<script type="text/javascript" src="/js/dataTable/datatables.min.js"></script>

<script type="text/javascript" src="/js/dataTable/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/js/dataTable/DataTables-1.10.18/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<!--bootbox-->
<script src="<%=request.getContextPath()%>/js/bootbox/bootbox.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootbox/bootbox.locales.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootStrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=basePath%>/js/ztree/jquery.ztree.all.min.js"></script>

<%--bootStrap上传--%>
<script type="text/javascript" src="/js/bootStrap-fileInput/js/fileinput.min.js"></script>
<script type="text/javascript" src="/js/bootStrap-fileInput/js/locales/zh.js"></script>
<script type="text/javascript">
    var v_addUser;
    $(function () {
        v_addUser= $("#addUser").html();

        initUserTable();//初始化日志信息
        initCheckBox();//初始化行变色复选框被选中
        initDateTime();//初始化时间
        initDaptZtree();//初始化项目ztree树

    })

    //初始化时间
    function initDateTime(diaLogDiv) {
        $(".form_datetime",diaLogDiv).datetimepicker({
            // 'yyyy-mm-dd hh:ii:ss'精确到时分秒
            format: 'yyyy-mm-dd',
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,//显示‘今日’按钮
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,  //Number, String. 默认值：0, 'hour'，日期时间选择器所能够提供的最精确的时间选择视图。
            clearBtn: true,//清除文本框按钮
            forceParse: 0,
            showClear:true,
            clealBen:true
        });
    }

    //解锁
    function userLockedStatus(id) {
        location.href = "<%=basePath%>/user/userLockedStatus.jhtml?id=" + id;
    }

    //用户信息展示
    var v_userTable;

    function initUserTable() {
        v_userTable = $('#userTable').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "<%=request.getContextPath()%>/user/findUserList.jhtml",
                "type": "POST",
                //用于处理服务器端返回的数据。 dataSrc是DataTable特有的
                dataSrc: function (result) {
                    //把dataTable里的数据是放在最外面的data里 所以要提取出来
                    //这样result.data.data就能取到值了 否则前台数据能显示出来但是分页插件不显示几页几条
                    result.draw = result.data.draw;
                    result.recordsFiltered = result.data.recordsFiltered;
                    result.recordsTotal = result.data.recordsTotal;
                    return result.data.data;
                }
            },
            //回调函数   js支持动态传参 参数可不传
            "fnDrawCallback": function () {
                //获取当前页面表格里面所有行的复选框 并循环
                $("#userTable tbody tr input[type='checkbox']").each(function () {
                    //获取复选框的值
                    var v_checkboxId = $(this).val();
                    //这个回显的方法是由返回值的 true  false
                    if (isExists(v_checkboxId)) {
                        //复选框 行变色都回显  closest获取父级元素
                        $(this).closest("tr").css("background", "cornsilk");
                        this.checked = true;
                    }

                })
            },
            "columns": [
                {
                    data: 'id',
                    "render": function (data, type, row, mate) {
                        return "<input type='checkbox' value='" + data + "'/>"
                    }
                },
                {data: 'id'},
                {data: 'userName'},
                {
                    data: 'userImage',
                    "render": function (data, type, row, mate) {
                        return "<img src='" + data + "' height='50'/>"
                    }
                },
                {
                    data: 'loginStatus',
                    "render": function (data, type, row, mate) {
                        return data == 0 ? '正常' : '锁定'
                    }
                },

                {data: 'userRealName'},
                {
                    data: 'birthday',
                    "render": function (data, type, row, meta) {
                        //时间格式化
                        var date = new Date(data);
                        var y = date.getFullYear();
                        var M = date.getMonth() + 1;
                        var d = date.getDate();
                        return y + '-' + M + '-' + d;
                    }
                },
                {
                    data: 'sex',
                    "render": function (data, type, row, mate) {
                        return data == 1 ? '男' : '女'
                    }
                },
                {data: 'salary'},
                {data: 'deptName'},
                {
                    data: 'id',
                    //渲染按钮
                    "render": function (data, type, row, mate) {
                        return "<div class='btn-group' role='group' aria-label='...'>" +
                            "  <button type='button' class='btn btn-info dropdown-toggle' onclick='userLockedStatus(\"" + data + "\")'>" +
                            "<span class='glyphicon glyphicon-wrench' aria-hidden='true'</span>解锁</button>" +
                            "</div>"
                    }
                },

            ],

            //去掉搜索框
            "searching": false,
            //每页显示的条数
            "lengthMenu": [3, 6, 9],
            "language": {
                "url": "<%=request.getContextPath()%>/js/dataTable/Chinese.json"
            }


        });
    }

    /**
     * 条件查询传递参数
     */
    function search() {
        var v_userName = $("#userName").val();
        var v_minBirthday = $("#minBirthday").val();
        var v_maxBirthday = $("#maxBirthday").val();
        var v_minSalary = $("#minSalary").val();
        var v_maxSalary = $("#maxSalary").val();
        //选择部门用户表也查询
        var v_deptTreeIds=$("#tree_deptIds").val();

        var param = {};
        param.userName = v_userName;
        param.minBirthday = v_minBirthday;
        param.maxBirthday = v_maxBirthday;
        param.minSalary = v_minSalary;
        param.maxSalary = v_maxSalary;
        param.deptTreeIds = v_deptTreeIds;
        //设置展示用户表的ajax里的data动态传参
        v_userTable.settings()[0].ajax.data = param;
        //重新加载
        v_userTable.ajax.reload();
    }


    /**
     * 点击变色复选框被选中 且翻页回显
     */
    var v_idArr = [];
    var userRowData;
    var v_checked;
    var checkedRow;
    function initCheckBox() {
        $("#userTable tbody").on("click", "tr", function () {
            checkedRow = $(this);
            //找到复选框
            v_checked = $(this).find("input[type='checkbox']")[0];
            //如果被选中 说明已经是选中状态 否则取消选中状态 删除到数组中对应的值 取消行色
            if (v_checked.checked) {
                v_checked.checked = false;
                $(this).css("background", "");
                //删除数组中的元素
                deleteidArr(v_checked.value);
            } else {
                //点击获取该行的数据
                userRowData = v_userTable.row(this).data();
                //将值添加到数组中 复选框被选中 行变色
                v_checked.checked = true;
                $(this).css("background", "cornsilk");
                v_idArr.push(v_checked.value);
            }

        })
    }

    //删除数组中的元素
    function deleteidArr(id) {
        for (var i = v_idArr.length - 1; i >= 0; i--) {
            if (id == v_idArr[i]) {
                v_idArr.splice(i, 1);
                console.log(v_idArr)
                break;
            }
        }
    }

    //复选框 行变色回显
    function isExists(checkboxId) {
        for (var i = 0; i < v_idArr.length; i++) {
            if (checkboxId == v_idArr[i]) {
                return true;
            }
        }
    }

    /**
     * ztree部门展示
     */
    var zTreeObj;
    var setting;
    var nodes;
    function initDaptZtree() {
        setting = {
            //zTree点击事件
            callback: {
                onClick: zTreeOnClick
            },
            data: {
                simpleData: {
                    enable: true,
                    //idKey: "id",渲染id
                    pIdKey: "fatherId",//渲染父节点
                },
                key: {
                    //渲染项目名
                    name: "deptName"
                }
            }
        };
        $.ajax({
            type: "post",
            url: "/dept/findDeptList.jhtml",
            success: function (result) {
                nodes=result.data;
                if (result.code == 200) {
                    zTreeObj = $.fn.zTree.init($("#daptTree"), setting, nodes);
                } else {
                    bootbox.alert({
                        message: '<span class="glyphicon glyphicon-ok"></span>获取信息失败',
                        size: 'small',
                        title: "提示信息"
                    });
                }
            }
        })


    }
    /**
     * zTree点击事件 使用户表根据选中的项目名查询
     */
    var v_nodeIdArr = [];
    var v_nodeChildrenId=[];//选中节点的儿子的id
    function zTreeOnClick() {
        //每次点击都先清空之前选中的(取消选中的节点)  已经选中的想取消再次点击就取消掉了
        v_nodeIdArr=[];
        //获取tree对象
        var treeObj = $.fn.zTree.getZTreeObj("daptTree");
        //获取选中的节点
        var v_selectedNodes = treeObj.getSelectedNodes();
        if(v_selectedNodes.length!=1){
            return ;
        }
        //获取选中节点的儿子
        var nodes = v_selectedNodes[0].children;
        if(nodes!=null){
            for (var i = 0; i < nodes.length; i++) {
                v_nodeChildrenId.push(nodes[i].id);
            }
        }
       // console.log(v_nodeChildrenId)
        //获取选中的节点下所有的子节点
        var nodes = treeObj.transformToArray(v_selectedNodes);
        //遍历
        for (var i = 0; i < nodes.length; i++) {
            //过滤掉数组中重复的节点id
            if (!isExist(nodes[i].id)) {
                v_nodeIdArr.push(nodes[i].id);
            }
        }
        //将数组转换成字符串添加到自定义（条件查询form表单）的文本框中
        $("#tree_deptIds").val(v_nodeIdArr.join(","));
        //用户表按选中的项目查询
         search();
    }
    /**
     * 条件查询点击重置 取消选中的节点并清空input框
     */
    function cancelSelectedNode() {
        //清空input
        document.getElementById("userForm").reset();

        /*$("#userName").val("");
         $("#minBirthday").val("");
        $("#maxBirthday").val("");
        $("#minSalary").val("");
        $("#maxSalary").val("");
        $("#tree_deptIds").val("");*/
        //清空数组
        v_nodeIdArr = [];
        var treeObj = $.fn.zTree.getZTreeObj("daptTree");
        treeObj.cancelSelectedNode();
        search();
    }
    function isExist(id){
        for(var i=0; i<v_nodeIdArr.length; i++){
            if(v_nodeIdArr[i]==id){
                return true;
            }
        }
    }
    /**
     * 添加部门
     */
    function showAddDept() {
        var treeObj = $.fn.zTree.getZTreeObj("daptTree");
        //获取选中的节点
        var v_selectedNodes = treeObj.getSelectedNodes();
        if (v_selectedNodes.length == 1) {
            //获取
            var v_nodeId = v_selectedNodes[0].id;
            //给父节点赋值
            $("#fatherId").attr("value", v_nodeId);
            /*bootbox弹框*/
            var v_AddDeptDialog = bootbox.dialog({
                title: '添加节点',
                message: $("#addDept").html(),
                // size: 'large',
                buttons: {
                    ok: {
                        label: '<span class="glyphicon glyphicon-ok"></span>确定',
                        className: 'btn-success',
                        callback: function () {
                            var v_fatherId = $("#fatherId", v_AddDeptDialog).val();
                            var v_deptName = $("#deptName", v_AddDeptDialog).val();
                            //innerText获取文本域的值
                            var v_remark = $("#remark", v_AddDeptDialog).val();
                            var param = {};
                            param.fatherId = v_fatherId;
                            param.deptName = v_deptName;
                            param.remark = v_remark;
                            //console.log(v_remark)
                            $.ajax({
                                url: "<%=request.getContextPath()%>/dept/addDept.jhtml",
                                type: "post",
                                data: param,
                                success: function (result) {
                                    if (result.code == 200) {
                                        //添加页面上的树信息
                                        var newNode = {};
                                        newNode.deptName = v_deptName;
                                        //result.data添加后通过select_key查看返回的id
                                        newNode.id = result.data;
                                        newNode.remark = v_remark
                                        treeObj.addNodes(v_selectedNodes[0], newNode);
                                    } else {
                                        bootbox.alert({
                                            message: '<span class="glyphicon glyphicon-exclamation-sign"></span>添加失败',
                                            size: 'small',
                                            title: "提示信息"
                                        });
                                    }
                                }
                            })
                        }
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove"></span>取消',
                        className: 'btn-danger',
                        callback: function () {
                            //Example.show('Custom cancel clicked');
                        }
                    }
                },
            });
        } else {
            bootbox.alert({
                message: '<span class="glyphicon glyphicon-ok"></span>请选择一个节点！',
                size: 'small',
                title: "提示信息"
            });
        }
    }

    /**
     *修改部门
     */
    function updateDept() {
        var treeObj = $.fn.zTree.getZTreeObj("daptTree");
        //获取选中的节点
        var v_selectedNodes = treeObj.getSelectedNodes();
        if (v_selectedNodes.length == 1) {
            //获取
            var v_nodeId = v_selectedNodes[0];
            //回显
            $("#update_Id").attr("value", v_nodeId.id);
            $("#update_deptName").attr("value", v_nodeId.deptName);
            $("#update_fatherId").attr("value", v_nodeId.fatherId);
            $("#update_remark").text(v_nodeId.remark);
            /*bootbox弹框*/
            var v_updateDeptDialog = bootbox.dialog({
                title: '添加节点',
                message: $("#updateDept").html(),
                // size: 'large',
                buttons: {
                    ok: {
                        label: '<span class="glyphicon glyphicon-ok"></span>确定',
                        className: 'btn-success',
                        callback: function () {
                            var v_id = $("#update_Id", v_updateDeptDialog).val();
                            var v_deptName = $("#update_deptName", v_updateDeptDialog).val();
                            var v_fatherId = $("#update_fatherId", v_updateDeptDialog).val();
                            //innerText获取文本域的值
                            var v_remark = $("#update_remark", v_updateDeptDialog).val();
                            //console.log(v_remark)
                            $.ajax({
                                url: "<%=request.getContextPath()%>/dept/updateDept.jhtml",
                                type: "post",
                                data: {
                                    "id": v_id,
                                    "deptName": v_deptName,
                                    "fatherId": v_fatherId,
                                    "remark": v_remark
                                },
                                success: function (result) {
                                    if (result.code == 200) {
                                        //修改页面上的树信息
                                        v_selectedNodes[0].deptName = v_deptName;
                                        v_selectedNodes[0].remark = v_remark;
                                        treeObj.updateNode(v_selectedNodes[0]);
                                    } else {
                                        bootbox.alert({
                                            message: '<span class="glyphicon glyphicon-exclamation-sign"></span>修改失败',
                                            size: 'small',
                                            title: "提示信息"
                                        });
                                    }
                                }
                            })
                        }
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove"></span>取消',
                        className: 'btn-danger',
                        callback: function () {
                            //Example.show('Custom cancel clicked');
                        }
                    }
                },
            });
        } else {
            bootbox.alert({
                message: '<span class="glyphicon glyphicon-ok"></span>请选择一个节点！',
                size: 'small',
                title: "提示信息"
            });
        }
    }

    /**
     *删除部门
     */
    function deleteDept() {
        var treeObj = $.fn.zTree.getZTreeObj("daptTree");
        //获取所有选中的节点
        var v_selectedNodes = treeObj.getSelectedNodes();

        if (v_selectedNodes.length > 0) {
            //数据转换为简单 Array 格式 递归获取所有的子节点
            var nodeArr = treeObj.transformToArray(v_selectedNodes);
            var idArr = [];
            //遍历所有的节点并将其id添加到数组中  并将数组id传到后台
            for (var i = 0, l = nodeArr.length; i < l; i++) {
                idArr.push(nodeArr[i].id)
            }
            bootbox.confirm({
                size: "small",
                message: "你确定删除吗！！！",
                callback: function (result) {
                    if (result) {
                        $.ajax({
                            url: '<%=request.getContextPath()%>/dept/deleteDept.jhtml',
                            type: "post",
                            async: true,
                            data: {"ids": idArr},
                            success: function (res) {
                                if (res.code == 200) {
                                    //删除页面上选中的节点
                                    for (var i = 0, l = nodeArr.length; i < l; i++) {
                                        treeObj.removeNode(nodeArr[i]);
                                    }
                                    bootbox.alert({
                                        message: '<span class="glyphicon glyphicon-ok"></span>删除成功',
                                        size: 'small',
                                        title: "提示信息"
                                    });
                                } else {
                                    bootbox.alert({
                                        message: '<span class="glyphicon glyphicon-exclamation-sign"></span>删除失败',
                                        size: 'small',
                                        title: "提示信息"
                                    });
                                }
                            }
                        })
                    }
                }
            })

        } else {
            bootbox.alert({
                message: '<span class="glyphicon glyphicon-ok"></span>请选择要删除的部门！',
                size: 'small',
                title: "提示信息"
            });
        }
    }

    /**
     * 删除用户
     */
    function deleteBatchUser() {
        //通过join将数组转换成字符串
        var v_ids = v_idArr.join(",");
        if (v_ids.length > 0) {
            bootbox.confirm({
                message: "您确定要删除吗?",
                size: "small",
                title: "提示信息",
                buttons: {
                    confirm: {
                        label: '<span class="glyphicon glyphicon-ok"></span>确定',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove"></span>取消',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if (result) {
                        $.ajax({
                            url: "<%=basePath%>/user/deleteBatchUser.jhtml",
                            type: "post",
                            async: true,
                            data: {"ids": v_ids},
                            success: function (res) {
                                if (res.code == 200) {
                                    bootbox.alert({
                                        message: '<span class="glyphicon glyphicon-ok"></span>删除成功',
                                        size: 'small',
                                        title: "提示信息"
                                    });
                                    search()
                                } else {
                                    bootbox.alert({
                                        message: '<span class="glyphicon glyphicon-exclamation-sign"></span>删除失败',
                                        size: 'small',
                                        title: "提示信息"
                                    });
                                }

                            },
                            error: function (res) {

                            }
                        })
                    }
                }
            })
        } else {
            bootbox.alert({
                message: '<span class="glyphicon glyphicon-hand-down"></span>请选择要删除的信息',
                size: 'small',
                title: "提示信息"
            });
        }
    }

    /**
     * 添加用户
     */
    var v_AddUserDialog;
    function addUser() {
        initUserImage();//图片上传
        /*bootbox弹框*/
         v_AddUserDialog = bootbox.dialog({
            title: '添加用户',
            message: $("#addUser form"),
            // size: 'large',
            buttons: {
                ok: {
                    label: '<span class="glyphicon glyphicon-ok"></span>确定',
                    className: 'btn-success',
                    callback: function () {
                        var v_userName = $("#add_userName", v_AddUserDialog).val();
                        var v_password = hex_md5($("#add_password", v_AddUserDialog).val());
                        var v_userImage =  $("#add_userImagePath",v_AddUserDialog).val();
                        var v_userRealName = $("#add_userRealName", v_AddUserDialog).val();
                        var v_birthday = $("#add_birthday", v_AddUserDialog).val();
                        var v_sex = $("input[name='sex']:checked", v_AddUserDialog).val();
                        var v_salary = $("#add_salary", v_AddUserDialog).val();
                        var v_id = $("#add_deptId", v_AddUserDialog).val();
                        var param = {};
                        param.userName = v_userName;
                        param.password = v_password;
                        param.userImage = v_userImage;
                        param.userRealName = v_userRealName;
                        param.birthday = v_birthday;
                        param.sex = v_sex;
                        param.salary = v_salary;
                        param["dept.id"] = v_id;
                        //console.log(v_remark)
                        $.ajax({
                            url: "<%=request.getContextPath()%>/user/addUser.jhtml",
                            type: "post",
                            data: param,
                            success: function (result) {
                                if (result.code == 200) {
                                    search();
                                } else {
                                    bootbox.alert({
                                        message: '<span class="glyphicon glyphicon-exclamation-sign"></span>用户添加失败',
                                        size: 'small',
                                        title: "提示信息"
                                    });
                                }
                            }
                        })
                    }
                },
                cancel: {
                    label: '<span class="glyphicon glyphicon-remove"></span>取消',
                    className: 'btn-danger',
                    callback: function () {
                        //Example.show('Custom cancel clicked');
                    }
                }
            },

        });
        initDateTime();//初始化时间
        $("#addUser").html(v_addUser)

    }

    /**
     * 上传图片
     */
    function initUserImage(){
        var info={
            language: 'zh',//配置语言
            uploadUrl: "/file/uploadFile.jhtml",//这个是配置上传调取的后台地址
            showUpload : true, //显示整体上传的按钮
            showRemove : true,//显示整体删除的按钮
            allowedPreviewTypes : ['image'],//预览的文件类型
            allowedFileExtensions : ["jpg","bmp", "png","gif","docx","zip","xlsx","txt"]//上传文件格式限制
        }
        $("#add_uploadImage").fileinput(info)
            .on("fileuploaded", function(event, data, previewId, index) {
                var result = data.response;
                if(result.code==200){
                    console.log(result.data)
                    $("#add_userImagePath",v_AddUserDialog).val(result.data);
                }else{
                    bootbox.alert({
                        message: '<span class="glyphicon glyphicon-exclamation-sign"></span>'+result.msg,
                        size: 'small',
                        title: "提示信息"
                    });
                }
            });
    }

    /**
     * 添加用户时选的部门树
     */
    function showDeptZtree(treeDialog,daptName,deptId) {
        $("#deptTreeDiv").html("<ul id='daptTree2' class='ztree'></ul>");
       $.fn.zTree.init($("#daptTree2"),setting,nodes);
           /*bootbox弹框*/
           bootbox.dialog({
               title: '请选择部门',
               message: $("#deptTreeDiv ul"),
               // size: 'large',
               buttons: {
                   ok: {
                       label: '<span class="glyphicon glyphicon-ok"></span>确定',
                       className: 'btn-success',
                       callback: function () {
                           var treeObj = $.fn.zTree.getZTreeObj("daptTree2");
                           //获取选中的节点
                           var v_selectedNodes = treeObj.getSelectedNodes();
                           if(v_selectedNodes.length==1){
                               //添加赋值

                               $("#"+daptName,treeDialog).val(v_selectedNodes[0].deptName);
                               $("#"+deptId,treeDialog).val(v_selectedNodes[0].id);
                           }else{
                               bootbox.alert({
                                   message: '<span class="glyphicon glyphicon-ok"></span>请选择一个节点！',
                                   size: 'small',
                                   title: "提示信息"
                               });
                           }

                       }
                   },
                   cancel: {
                       label: '<span class="glyphicon glyphicon-remove"></span>取消',
                       className: 'btn-danger',
                       callback: function () {
                           //Example.show('Custom cancel clicked');
                       }
                   }
               },
           });


    }

    /**
     * 修改用户
     */
    var v_updateUserDialog;
    function updateUser() {
        //获取被选中的复选框的值
        var v_selectRow_count  = $("#userTable tbody tr input[type='checkbox']:checked").length;

        if(v_selectRow_count==1){
        /*bootbox弹框*/
        v_updateUserDialog = bootbox.dialog({
            title: '修改用户',
            message: $("#updateUser").html(),
            // size: 'large',
            buttons: {
                ok: {
                    label: '<span class="glyphicon glyphicon-ok"></span>确定',
                    className: 'btn-success',
                    callback: function () {
                        var v_id = $("#update_UserId", v_updateUserDialog).val();
                        var v_oldUserImage = $("#oldUserImagePath", v_updateUserDialog).val();
                        var v_userImage = $("#newUserImagePath", v_updateUserDialog).val();
                        var v_userName = $("#update_userName", v_updateUserDialog).val();
                        var v_userRealName = $("#update_userRealName", v_updateUserDialog).val();
                        var v_birthday = $("#update_birthday", v_updateUserDialog).val();
                        var v_sex = $("input[name='sex']:checked", v_updateUserDialog).val();
                        var v_salary = $("#update_salary", v_updateUserDialog).val();
                        var v_deptId = $("#update_deptId", v_updateUserDialog).val();
                        var param = {};
                        param.id = v_id;
                        param.userName = v_userName;
                        param.oldUserImage = v_oldUserImage;
                        param.userImage = v_userImage;
                        param.userRealName = v_userRealName;
                        param.birthday = v_birthday;
                        param.sex = v_sex;
                        param.salary = v_salary;
                        param["dept.id"] = v_deptId;
                        //console.log(v_remark)
                        $.ajax({
                            url: "<%=request.getContextPath()%>/user/updateUser.jhtml",
                            type: "post",
                            data: param,
                            success: function (result) {
                                if (result.code == 200) {
                                    search();
                                } else {
                                    bootbox.alert({
                                        message: '<span class="glyphicon glyphicon-exclamation-sign"></span>用户修改失败',
                                        size: 'small',
                                        title: "提示信息"
                                    });
                                }
                            }
                        })
                    }
                },
                cancel: {
                    label: '<span class="glyphicon glyphicon-remove"></span>取消',
                    className: 'btn-danger',
                    callback: function () {

                    }
                }
            }

        });
        //修改回显
        var rowId="";

            rowId = $("#userTable tbody tr input[type='checkbox']:checked")[0].value;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/user/findUser.jhtml",
                data:{"id":rowId},
                success:function(result){
                    var data = result.data;
                    //回显
                    $("#update_UserId").val(rowId);
                    $("#update_userName").val(data.userName);
                    $("#oldUserImagePath").val(data.userImage);
                    //图片回显
                    var v_imagePathArr = [];
                    v_imagePathArr.push(data.userImage);
                    //console.log(v_imagePathArr);
                    initUpdateUserImage(v_imagePathArr);

                    $("#update_userRealName").val(data.userRealName);
                    $("[name='sex'][value='"+data.sex+"']").prop("checked",true);
                    var date = new Date(data.birthday);
                    var y = date.getFullYear();
                    var M = date.getMonth() + 1;
                    var d = date.getDate();
                    $("#update_birthday").val(y + '-' + M + '-' + d);
                    $("#update_salary").val(data.salary);
                    $("#update_UserdeptName").val(data.deptName);
                    $("#update_deptId").val(data.deptId);

                    initDateTime(v_updateUserDialog);//加载时间插件
                }
            });

        }else{
            bootbox.alert({
                message: '<span class="glyphicon glyphicon-hand-down"></span>请选择一条数据',
                size: 'small',
                title: "提示信息"
            });
        }
        v_checked.checked=false;
        checkedRow.css("background","");
        v_idArr=[];

    }

    /**
     * 修改上传图片
     */
    function initUpdateUserImage(imageArr){
        var info={
            language: 'zh',//配置语言
            uploadUrl: "/file/uploadFile.jhtml",//这个是配置上传调取的后台地址
            //图片回显
            initialPreview:imageArr,
            initialPreviewAsData:true,//特别重要
            showUpload : true, //显示整体上传的按钮
            showRemove : true,//显示整体删除的按钮
            //allowedPreviewTypes : ['image'],//预览的文件类型
            allowedFileExtensions : ["jpg","bmp", "png","gif","docx","zip","xlsx","txt"]//上传文件格式限制
        }
        $("#update_uploadImage").fileinput(info)
            .on("fileuploaded", function(event, data, previewId, index) {
                var result = data.response;
                if(result.code==200){
                    console.log(result.data)
                    $("#newUserImagePath").val(result.data);
                }else{
                    bootbox.alert({
                        message: '<span class="glyphicon glyphicon-exclamation-sign"></span>'+result.msg,
                        size: 'small',
                        title: "提示信息"
                    });
                }
            });
    }
    /**
     * 批量修改用户所在的部门
     */

    function BatchUpdateUserDept() {
        if(v_idArr.length>0){
            $("#deptTreeDiv").html("<ul id='daptTree2' class='ztree'></ul>");
            $.fn.zTree.init($("#daptTree2"),setting,nodes);
            /*bootbox弹框*/
            bootbox.dialog({
                title: '请选择部门',
                message: $("#deptTreeDiv ul"),
                // size: 'large',
                buttons: {
                    ok: {
                        label: '<span class="glyphicon glyphicon-ok"></span>确定',
                        className: 'btn-success',
                        callback: function () {
                            var treeObj = $.fn.zTree.getZTreeObj("daptTree2");
                            //获取选中的节点
                            var v_selectedNodes = treeObj.getSelectedNodes();
                            if(v_selectedNodes.length==1){
                                //添加赋值
                                var v_deptId = v_selectedNodes[0].id;
                                $.ajax({
                                    type:"post",
                                    url:"<%=request.getContextPath()%>/user/BatchUpdateUserDept.jhtml",
                                    data:{
                                        "deptId":v_deptId,
                                        "ids":v_idArr
                                    },
                                    success:function (res) {
                                        if(res.code==200){
                                            //刷新
                                            search();
                                            v_checked.checked=false;
                                            checkedRow.css("background","");
                                            v_idArr=[];
                                        }else{
                                            bootbox.alert({
                                                message: '<span class="glyphicon glyphicon-hand-down"></span>修改失败',
                                                size: 'small',
                                                title: "提示信息"
                                            });
                                        }
                                    }
                                })

                            }else{
                                bootbox.alert({
                                    message: '<span class="glyphicon glyphicon-ok"></span>请选择一个节点！',
                                    size: 'small',
                                    title: "提示信息"
                                });
                            }

                        }
                    },
                    cancel: {
                        label: '<span class="glyphicon glyphicon-remove"></span>取消',
                        className: 'btn-danger',
                        callback: function () {
                            //Example.show('Custom cancel clicked');
                        }
                    }
                },
            });

        }else {
            bootbox.alert({
                message: '<span class="glyphicon glyphicon-hand-down"></span>请选择',
                size: 'small',
                title: "提示信息"
            });
        }

    }

    /**
     * 按部门导出Excel
     */
    function importExcelByDept() {
        if(v_nodeChildrenId.length>0){
            var productFrom = document.getElementById("userForm");
            productFrom.action = "<%=request.getContextPath()%>/user/importExcelByDept.jhtml?childNode="+v_nodeChildrenId;
            productFrom.method = "post"
            productFrom.submit();
            //清空数组
            v_nodeChildrenId=[];
        }else{
            bootbox.alert({
                message: '<span class="glyphicon glyphicon-hand-down"></span>请选择部门',
                size: 'small',
                title: "提示信息"
            });
        }

    }

</script>
<script type="text/html" id="updateUser">
        <form class="form-horizontal" method="post">
            <input type="text" class="form-control" placeholder="admin" id="update_UserId">
            <div class="form-group">
                <label class="col-md-2 control-label"> 员工名</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="admin" id="update_userName">
                </div>
            </div>
            <div  class="row">
                <label class="col-sm-2 control-label">用户图片</label>
                <div class="col-md-8">
                    <input type="file" name="productImage" class="file" id="update_uploadImage"/>
                </div>
                <input type="text" id="newUserImagePath">
                <input type="text"  id="oldUserImagePath">
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">真实姓名</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="update_userRealName">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">生日</label>
                <div class="col-md-4">
                    <input type="text" class="form-control form_datetime" id="update_birthday">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">性别</label>
                <div class="col-md-4">
                    <input type="radio" name="sex" value="1">男
                    <input type="radio" name="sex" value="2">女
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">薪资</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="update_salary">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">部门</label>
                <div class="input-group col-md-4">
                    <input type="text" class="form-control" id="update_UserdeptName">
                    <span class="input-group-btn">
                    <button class="btn btn-info" type="button" onclick="showDeptZtree(v_updateUserDialog,'update_UserdeptName','update_deptId')">选择</button>
                 </span>

                </div>
                <input type="text" class="col-md-4" id="update_deptId">
            </div>
        </form>
</script>
</body>
</html>