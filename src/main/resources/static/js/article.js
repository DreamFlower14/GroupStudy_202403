// 삭제 기능
const selectBtn = document.getElementById("select-btn");

if (selectBtn) {
    selectBtn.addEventListener('click', event => {
        let id = document.getElementById("article-id").value;
        console.log(id)
        fetch(`/fetch/test`)
            .then(res =>res.body)
            .then(text => console.log(text))
    })
}