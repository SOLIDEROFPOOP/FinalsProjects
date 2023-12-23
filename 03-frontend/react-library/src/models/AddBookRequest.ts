class AddBookRequest{
    title:string;
    autor:string;
    description:string;
    copies:number;
    category:string;
    img?:string;
    constructor( title:string,autor:string,description:string,copies:number,category:string){
        this.title = title;
        this.autor = autor;
        this.description = description;
        this.copies = copies;
        this.category = category;
    }

}
export default AddBookRequest;