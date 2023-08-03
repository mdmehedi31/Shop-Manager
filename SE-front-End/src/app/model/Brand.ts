
export class Brand {


    constructor( public brandName:string,
        public catNameId:{
            catId:Object,
        },
        public attachmentEntity:File | null
        ){}
}