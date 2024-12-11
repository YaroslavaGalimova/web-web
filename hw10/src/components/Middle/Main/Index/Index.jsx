import React, {useMemo} from 'react';
import comments from "../../../../assets/img/comments.png";

const Index = ({posts}) => {
    const sortedPosts = useMemo(() => {
        if (!posts)
            return []
        return posts.sort((a, b) => b.id - a.id)
    }, [posts])

    return (
        <div>
            {
                sortedPosts.map((post, index) => (
                    <article key={index}>
                        <div class="title">{post.title}</div>
                        <div class="body">{post.text}</div>
                        <div class="footer">
                            <div class="right">
                                <img src={comments} title="Comments" alt="Comments"/>
                                <a href="#">{post.comments === undefined ? 0 : post.comments}</a>
                            </div>
                        </div>
                    </article>
                ))
            }
        </div>
    );
};

export default Index;