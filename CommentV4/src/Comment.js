import React from 'react';
class Comment extends React.Component{

    // custom method to handle click of Delete
    _handleDelete(event){
        // prevent default behavior
        event.preventDefault();

        // need to call the prop method
        this.props.onDelete(this.props.commentdata);
    }
    render(){
        return (
            <div>
                {/*<p><h4>Author : {this.props.commentdata.author}</h4></p>*/}
                <p><h4>Author : {this.props.commentdata.author}</h4></p>
                <p>{this.props.commentdata.body}</p>
                <p>Tags : {this.props.commentdata.tag}</p>
                <div>
                    <a href='#' onClick={this._handleDelete.bind(this)}>Delete</a>
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