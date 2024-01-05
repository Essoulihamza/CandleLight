import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { PostService } from 'src/app/Services/Service/PostService/post.service';
import { Post, PostInput } from 'src/app/Types/PostTypes';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private postservice: PostService) { }
  posts: any;
  paginatePosts: Post[] = [];

  formdata: PostInput = {
    title: "title",
    content: "content",
    Tags: ["check", "check 2", "check 3"],
    publisher: 1
  }

  ngOnInit(): void {
    this.postservice.getPostById(5).subscribe((data) => {
      this.posts = data;
    });

    this.postservice.getPosts(0, 10).subscribe((data) => {
      this.paginatePosts = data;
    });
  }

  log() {
    console.log(this.paginatePosts);
  }


  create(){
    this.postservice.createPost(this.formdata).subscribe((data) => {
      console.log(data);
    });
  }

}
