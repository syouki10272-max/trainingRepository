<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    // セッションにユーザーが残っていると login.jsp が main.jsp にリダイレクトするため、
    // テスト時は必ずログインフォームが表示されるようにする
    session.removeAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login.jsp テスト</title>
    <style>
        body { font-family: sans-serif; margin: 20px; }
        .pass { color: green; }
        .fail { color: red; }
    </style>
</head>
<body>
    <h1>login.jsp テスト</h1>
    <div id="test-results"></div>

    <h2>レンダリング結果</h2>
    <div id="login-page">
        <jsp:include page="login.jsp" />
    </div>

    <script>
        function addResult(text, passed) {
            const div = document.createElement('div');
            div.textContent = text;
            div.className = passed ? 'pass' : 'fail';
            document.getElementById('test-results').appendChild(div);
        }

        function runTests() {
            const form = document.querySelector('#login-page form');
            if (!form) {
                addResult('FAIL: login.jsp にフォームが見つかりません。', false);
                return;
            }

            addResult('PASS: login.jsp にフォームが存在します。', true);

            addResult(
                form.method.toUpperCase() === 'POST'
                    ? 'PASS: フォームの method は POST です。'
                    : 'FAIL: フォームの method は POST ではありません。',
                form.method.toUpperCase() === 'POST'
            );

            const action = form.getAttribute('action') || '';
            addResult(
                action === 'login' || action.endsWith('/login')
                    ? 'PASS: フォームの action は login です。'
                    : 'FAIL: フォームの action が期待値と異なります (' + action + ')。',
                action === 'login' || action.endsWith('/login')
            );

            const idInput = form.querySelector('input[name="id"]');
            addResult(
                idInput ? 'PASS: ID 用の input(name="id") が存在します。' : 'FAIL: ID 用の input(name="id") が存在しません。',
                !!idInput
            );

            const passwordInput = form.querySelector('input[name="password"]');
            addResult(
                passwordInput ? 'PASS: password 用の input(name="password") が存在します。' : 'FAIL: password 用の input(name="password") が存在しません。',
                !!passwordInput
            );

            const submitButton = form.querySelector('button[type="submit"], input[type="submit"]');
            addResult(
                submitButton ? 'PASS: 送信ボタンが存在します。' : 'FAIL: 送信ボタンが存在しません。',
                !!submitButton
            );
        }

        window.addEventListener('DOMContentLoaded', runTests);
    </script>
</body>
</html>