<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix= "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Escolas</h1>
    </div>
    <!-- Content Row -->
    <div class="row">
        <div class="col-12">
            <table id="datatable" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th align="left">ID</th>
                        <th align="left">Nome</th>
                        <th align="left">Endereço</th>
                        <th align="left">Telefone</th>
                        <th align="right"></th>
                        <th align="right"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="escola" items="${escolas}">
                        <tr>
                            <td align="left">${escola.idescola}</td>
                            <td align="left">${escola.nomeescola}</td>
                            <td align="left">${escola.endereco}</td>
                            <td align="left">${escola.telefone}</td>
                            <td align="center">
                                <a href=
                    "${pageContext.request.contextPath}/EscolaExcluir?idescola=${escola.idescola}">
                                Excluir</a></td>
                            <td align="center">
                                <a href=
                    "${pageContext.request.contextPath}/EscolaCarregar?idescola=${escola.idescola}">
                                Alterar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-center mt-4">
                <a href="${pageContext.request.contextPath}/EscolaNovo" class="btn btn-primary">Novo</a>
                <a href="index.jsp" class="btn btn-secondary">Voltar à Página Inicial</a>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->
 
<script>
    $(document).ready(function(){
        console.log('entre ready');
        //Carregamos a datatable
        //$("#datatable").DataTable({});
        $("#datatable").DataTable({
            "oLanguage":{
                "sProcessing": "Processando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "Nenhum registro encontrado.",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                "sInfoFiltered": "",
                "sInforPostFix": "",
                "sSearch": "Buscar",
                "sUrl": "",
                "oPaginate":{
                    "sFist": "Primeiro",
                    "sPrevious": "Anterior",
                    "snext": "Seguinte",
                    "sLast": "Último"
                }
            }
        });
    });
</script>

<%@ include file="/footer.jsp"%>
