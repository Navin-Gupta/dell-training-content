import React from 'react';
import Comment from './Comment';

class CommentBox extends React.Component{

    // constructor
    constructor(){
        // req to call the base class constructor
        super();

        // set the initial value of state object
        this.state = {
            showComment : false
        }
    }

    // add a custom method for managing comments
    // 1. hold the repo of comments
    // 2. generate a JSX for list of comments
    // 3. _ helps to distinguish custom methods from React Ones
    _getComments(){
        // repo
        const commentList = [
            {author : "First", body: "This is first comment!"},
            {author : "Second", body: "This is second comment!", tag:"#Good Post"},
            {author : "Third", body: "This is third comment!"},
            {author : "Fourth", body: "This is fourth comment!", tag:"#Quite Informative"}
        ];

        // JSX
        let commentJSX =  commentList.map(comment => {
            // return(<Comment commentdata={comment}/>);
            if(comment.tag)
                return(<Comment author={comment.author} comment={comment.body} tags={comment.tag}/>);
            else    
                return(<Comment author={comment.author} comment={comment.body}/>);
        });

        // return
        return commentJSX;

    }

    // custom method to handle click of button (show/hide)
    _handleClick(){
        // changing the state value
        // not a preferred way, it updates complete state object
        // this.state.showComment = !this.state.showComment;
        // special inbuilt method to change state value
        this.setState({ //  will call render method internally
            showComment : !this.state.showComment
        });
    }

    render(){
        // call _getComments()
        const comments = this._getComments();
        let commentNodes;
        let buttonText = "Show Comments";
        if(this.state.showComment == true){
            buttonText = "Hide Comments";
            commentNodes =  <div id='comment-list'>
                                {comments}
                            </div>   
        }
        return(
            <div>
                <h1>Some Blog Post!!!</h1>
                <h3>{comments.length} Comments</h3>
                <button id='show_hide_btn' 
                onClick={this._handleClick.bind(this)}>{buttonText}</button>
                <hr/>
                {commentNodes}
            </div>
        );
    }
}

export default CommentBox;