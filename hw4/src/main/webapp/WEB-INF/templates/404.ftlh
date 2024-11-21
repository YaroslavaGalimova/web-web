<#import "./common.ftlh" as c>

<@c.page>

<style>
main div.error_table {
    display: flex;
    align-items: center;
    justify-content: space-between;
    text-align: left;
    padding: 10px;
    border: var(--border);
    border-radius: var(--border-radius);
}

main div div.error {
    color: var(--caption-color);
    font-size: 16pt;
    margin-right: 10px;
}

main div.error_table img {
    height: auto;
    float: right;
}
</style>

<div class="error_table">
    <div>
    <div class="error">404</div>
    No such directory
    </div>
    <img src="../../img/error-photo.jpg" alt="no photo"/>
</div>
</@c.page>

