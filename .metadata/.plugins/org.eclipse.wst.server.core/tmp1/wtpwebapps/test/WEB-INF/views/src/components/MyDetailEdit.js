import React from 'react';
import './PersonDetail.css';
import './MyDetail.css';

class MyDetailEdit extends React.Component{
    state={
        des : this.props.des,
        job : this.props.job
    }
    inputChange = (e) =>{
        let targetId = e.target.id
        if(targetId==='description'){
            this.setState({
                des : e.target.value
            });
        }else if(targetId==='job'){
            this.setState({
                job : e.target.value
            });
        }

    }
    onFormSubmit = (e) =>{
        e.preventDefault();
    }

    render(){
        //ui container two column centered grid
        const createLikeBtn = (likeArr) =>{
           // console.log("likearr=",likeArr)
            let likeBtn = '';
            if(likeArr !== null &&likeArr !== ''  ){
                likeBtn = likeArr.map( (like,i) => {
                return <button key={i} className="ui basic button likeBtn">{like}</button>
            
             });           
            }
            return likeBtn
        }
        
        return(  
            <div className="ui container two column centered grid" id="cardbody">
            <div className="ui card column">
                <div className="card ">
                    <div className="extra content">
                        <div>                        
                            {createLikeBtn(this.props.like)}
                        </div>                        
                    </div> 
                    <form className="ui fluid form" onSubmit={this.onFormSubmit}>
                    <div className="content">
                        <div className="header">{this.props.name} 님 소개</div>
                        <div className="meta">
                            <input type='text' id="description" value={this.state.des} onChange={this.inputChange}/>
                        </div>
                    </div>
                    <div className="extra content">
                        <div className="header">직업</div>
                        <div className="meta">
                            <input type='text' id="job" value={this.state.job} onChange={this.inputChange}/>
                        </div>                       
                    </div> 

                    <div className="extra content">
                        <div className="image">
                            <img src={this.props.img} alt="userImage" id="profileImage"/>
                        </div> 
                        <div className="editBtn">
                            <button class="ui pink button" onClick={this.props.changeDisplay}>Save</button>
                        </div>
                    </div>
                    </form>   
                    
                </div>  
            </div>
            </div>
        )
    }
}

export default MyDetailEdit;