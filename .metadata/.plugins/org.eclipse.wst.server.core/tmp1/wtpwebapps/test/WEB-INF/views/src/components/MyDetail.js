import React from 'react';
import './PersonDetail.css';
import './MyDetail.css';

class MyDetail extends React.Component{

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
                     
                    <div className="content">
                        <div className="header">{this.props.name}</div>
                        <div className="meta">{this.props.age}</div>
                        <div className="meta">{this.props.job}</div>
                    </div>
                    <div className="extra content">
                        <div>
                        
                            {createLikeBtn(this.props.like)}
                        </div>                        
                    </div> 
                    
                    <div className="extra content">
                        <div>
                            <hr/>
                            <div className="description">{this.props.des}</div>
                        </div>                        
                    </div>
                    <div className="extra content">
                        <div className="image">
                            <img src={this.props.img} alt="userImage" id="profileImage"/>
                        </div> 
                        <div className="editBtn">
                            <button class="ui pink button" onClick={this.props.changeDisplay}>Edit</button>
                        </div>
                    </div>   
                    
                </div>  
            </div>
            </div>
        )
    }
}

export default MyDetail;