import React from 'react';
import Comment from './Comment';
import CommentForm from './CommentForm';
import $ from 'jquery';

class CommentBox extends React.Component{

    // constructor
    constructor(){
        // req to call the base class constructor
        super();

        // set the initial value of state object
        this.state = {
            showComment : false,
            // initialize commentList with empty data [no hard coded data]
            commentList : []
        }
    }

    // custom method to fetch comments from server
    _fetchComments(){
        // fetch data from server
        // $.ajax(<details of request>);
        $.ajax({
           method : 'GET',
           url : ' http://localhost:3000/comments',
           success : (data)=>{
               // update the state object
               this.setState({
                   commentList : data
               });
           },
           error : (error) => {} 
        });
    }

    // life cycle hook method
    componentWillMount(){
        this._fetchComments();
    }

    // life cycle hook method to add polling
    componentDidMount(){
        // set a interval to call _fetchComments()
        this._timer = setInterval(()=> this._fetchComments(), 5000);
    }

    // life cycle hook to clean resources
    componentWillUnmount(){
        // wheneever to stop polling
        clearInterval(this._timer);
    }

    // add a custom method for managing comments
    // 1. hold the repo of comments
    // 2. generate a JSX for list of comments
    // 3. _ helps to distinguish custom methods from React Ones
    _getComments(){
        
        // JSX
        let commentJSX =  this.state.commentList.map(comment => {
            return(<Comment comment_key={comment.id} 
                            commentdata={comment} 
                            onDelete={this._deleteComment.bind(this)}/>);
            /*if(comment.tag)
                return(<Comment author={comment.author} comment={comment.body} tags={comment.tag}/>);
            else    
                return(<Comment author={comment.author} comment={comment.body}/>);
            */    
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

    // custom method to add new comment
    _addComment(new_author, new_comment, new_tag){
        // logic to add new comment to our collection

        // create a new comment object
        const new_comment_object = {
            id : this.state.commentList.length + 1,
            author : new_author,
            body : new_comment,
            tag : new_tag
        };

        // add to collection : update the state object
        this.setState({
            commentList : this.state.commentList.concat([new_comment_object])
        })
    }

    // custom method for deleting a comment
    _deleteComment(comment){

        // search for comment object in collection
        // create a clone  [ES6 spread operator]
        const comments = [...this.state.commentList];

        // fetch the index of comment
        const index = comments.indexOf(comment);
        comments.splice(index, 1);

        // update the state 
        this.setState({
            commentList : comments
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
                <hr/>
                <CommentForm addComment={this._addComment.bind(this)}/>
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