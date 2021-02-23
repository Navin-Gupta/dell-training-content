import React from 'react';
class Comment extends React.Component{

    render(){
        return (
            <div>
                {/*<p><h4>Author : {this.props.commentdata.author}</h4></p>*/}
                <p><h4>Author : {this.props.author}</h4></p>
                <p>{this.props.comment}</p>
                <p>Tags : {this.props.tags}</p>
                <div>
                    <a href='#'>Delete</a>
                </div>
            
                <hr/>  
            </div>        
        );
    }
}

Comment.defaultProps = {
    tags : "#notags"
}

export default Comment;