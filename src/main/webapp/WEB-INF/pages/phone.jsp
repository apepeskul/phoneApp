<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css"
      href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
      href="../../resources/DT_bootstrap.css">
<link rel="stylesheet" type="text/css"
      href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/cupertino/jquery-ui.css"/>
<link rel="stylesheet" type="text/css"
      href="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.0/css/bootstrap-responsive.min.css"/>
<link rel="stylesheet" type="text/css" href="http://getbootstrap.com/examples/sticky-footer/sticky-footer.css"/>
<link rel="stylesheet" type="text/css" href="../../resources/style.css">

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="../../resources/bootstrap.js"></script>
<script src="../../resources/bootstrap_confirmation.js"></script>
<script type="text/javascript" charset="utf8"
        src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../resources/DT_bootstrap.js"></script>
<script type="text/javascript" src="../../resources/home.js"></script>
<script type="text/javascript" src="../../resources/fnReloadAjax.js"></script>
<html>
<head>
    <title>Phone</title>
</head>
<body>
<%--  asdasfgasdgasdgasg
  ${phones}
  <c:forEach items="${phones}" var="phone">
  <br/>
      <c:out value="${phone.firstName} ${phone.lastName}"/>
      <br/>
      <c:out value="${phone.phone}"/>
  </c:forEach>--%>
<%--${phone.firstName}
<br>
${phone.phone}--%>
<div class="container-fluid">
    <%--  <div class="row-fluid">
          <div class="span8 offset2">
              <div class="row" style="border-bottom: inactiveborder">
                  <div class="span7">
                      <input type="button" class="btn btn-primary" id="btnNew" value="Add new">
                      <br/>
                      <br/>
                      <br/>
                      <hr/>

                  </div>
              </div>
          </div>
      </div>--%>
    <div class="row-fluid">
        <div class="span10 offset1">
        <input type="button" class="btn btn-primary" id="addBtn" value="Add new"/>
            <div class="well well-large">

                <div class="span12" id="tablespan">

                    <table cellpadding="0" cellspacing="0" border="0"
                           class="table table-striped table-bordered table-hover"
                           id="table">
                        <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Phone</th>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>

                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Phone</th>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                        </tr>
                        </tfoot>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="modal fade hide" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Edit</h4>
                </div>
                <div class="modal-body" id="body">
                    <div class="span4">
                        <form id="editForm" class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label" for="modalId"/>

                                <div class="controls">
                                    <input type="hidden" id="modalId" name="id"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="modalLastName">Last name: </label>

                                <div class="controls">
                                    <input type="text" id="modalLastName" name="lastName"/>
                                    <br/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="modalFirstName">First name: </label>

                                <div class="controls">
                                    <input type="text" id="modalFirstName" name="firstName"/>
                                </div>
                                <br/>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="modalPhone">Phone: </label>

                                <div class="controls">
                                    <input type="text" id="modalPhone" name="phone"/>
                                </div>
                                <br/>
                            </div>
                            <div id="msg"></div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">Close
                    </button>
                    <input type="submit" id="modalSubmit" value="Save" class="btn btn-primary"/>
                    </form>
                </div>
            </div>
        </div>

    </div>

</div>


</body>
</html>
