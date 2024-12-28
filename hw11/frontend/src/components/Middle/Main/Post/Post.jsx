import { useParams } from "react-router-dom";
import Index from "../Index/Index";

const Post = ({posts}) => {

    const {id} = useParams()

    if (posts === null || posts.length === 0) {
        return (<Index posts={[]}/>)
    }

    const post = posts.find(p => p.id === parseInt(id))
    return (<Index posts={[post]}/>)
}

export default Post;