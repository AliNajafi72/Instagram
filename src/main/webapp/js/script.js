$(document).ready(function () {
    let searchInputPlaceholder = document.getElementById("search-input-placeholder");
    let searchInput = document.getElementById("search-input");
    searchInput.addEventListener("click", () => {
        searchInputPlaceholder.style.visibility = "hidden";
    })
    searchInput.addEventListener("focusout", () => {
        if (searchInput.value === "") {
            searchInputPlaceholder.style.visibility = "visible";
        }
    })
    searchInputPlaceholder.addEventListener("click", () => {
        searchInputPlaceholder.style.visibility = "hidden";
        searchInput.focus();
    })
    searchInputPlaceholder.addEventListener("focusout", () => {
        if (searchInput.value === "") {
            searchInputPlaceholder.style.visibility = "visible";
        }
    })
    searchInput.addEventListener("input", () => {
        if (searchInput.value === "") {
            searchInputPlaceholder.style.visibility = "visible";
        }
    })

    $('.saved-stories-inner').slick({
        slidesToShow: 8,
        prevArrow: false,
        nextArrow: false,
    })

});

async function getPostsData() {
    let ajaxRequest = await fetch('http://localhost:8080/Gradle___org_example___Instagram_1_0_SNAPSHOT_war/userposts')
    return await ajaxRequest.json()
}

let html = ''

async function renderPosts() {
    let posts = await getPostsData();
    posts.forEach(post => {
        let innerHTML =
            `
                <div id="post-content" class="col-4 post-content d-flex">
                    <img id="post-image" class="post-image" src="img/landscape-photo.jpg">
                    <div id="post-icon-container" class="post-icon-container">
                        <img class="post-favorite-icon post-icon" src="img/favorite-white-icon.svg">
                        <b>${post.likeNumber}</b>
                        <img class="post-comment-icon post-icon" src="img/comment-white-icon.svg">
                        <b>100</b>
                    </div>
                </div>
            `
        let postInnerGrid = document.querySelector('.row')
        postInnerGrid.innerHTML += innerHTML
        let postIconContainer = document.getElementById("post-icon-container");
        document.getElementById("post-content").addEventListener("mouseover", () => {
            postIconContainer.style.animationName = "posts-icon-brightness";
            postIconContainer.style.animationDuration = "1s";
            postIconContainer.style.animationFillMode = "forwards";
        })
        document.getElementById("post-content").addEventListener("mouseleave", () => {
            postIconContainer.style.animationName = "none";
        })

        document.getElementById("post-content").addEventListener("mouseover", () => {
            document.getElementById("post-image").style.animationName = "posts-image-brightness";
            document.getElementById("post-image").style.animationDuration = "1s";
            document.getElementById("post-image").style.animationFillMode = "forwards";
        })

        document.getElementById("post-content").addEventListener("mouseleave", () => {
            document.getElementById("post-image").style.animationName = "none";
        })
    })

}

renderPosts()
