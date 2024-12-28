import React, {useMemo} from 'react';
const Index = ({posts}) => {
    const sortedPosts = useMemo(() => {
        if (!posts)
            return []
        return posts.sort((a, b) => a.id - b.id)
    }, [posts])

    if (posts === null || posts.length === 0) {
        return <div>No posts found. Wait...</div>;
    }

    return (
        <div>
            {
                sortedPosts.map((post, index) => (
                    <article key={index}>
                        <div class="title">{post.title}</div>
                        <div class="body">{post.text}</div>
                    </article>
                ))
            }
        </div>
    );
};

export default Index;