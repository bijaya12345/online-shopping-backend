import { productConstants } from '../../_constants/productConstants';
const initialState = {
    products: []

};

const productReducer = (state = initialState, action) => {

    switch (action.type) {
        case productConstants.PRODUCT_ADD:
            return {
                ...state,
                products: action.products.params.products
            };
        case productConstants.PRODUCT_LIST:
            return {
                ...state,
                products: action.products.params.products
            };
        case productConstants.PRODUCT_UPDATE:
            return state;
        case productConstants.PRODUCT_DELETE:
            return state;
        default:
            return state;
    }
};

export default productReducer;