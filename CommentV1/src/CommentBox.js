import React from 'react';
import Comment from './Comment';

class CommentBox extends React.Component{

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

    render(){
        // call _getComments()
        const comments = this._getComments();
        return(
            <div>
                <h1>Some Blog Post!!!</h1>
                <h3>{comments.length} Comments</h3>
                <hr/>
                {comments}
                {/*
                    <Comment author="First" comment="First Comment"/>
                    <Comment author="Second" comment="Second Comment"/>
                    <Comment author="Third" comment="Third Comment"/>
                */}
                {/*
                    <div>
                        <p><h4>Author : First</h4></p>
                        <p>First Comment....</p>
                        <div>
                            <a href='#'>Delete</a>
                        </div>
                    </div>
                    <hr/>
                    <div>
                        <p><h4>Author : Second</h4></p>
                        <p>Second Comment....</p>
                        <div>
                            <a href='#'>Delete</a>
                        </div>
                    </div>
              */}
            </div>
        );
    }
}

export default CommentBox;