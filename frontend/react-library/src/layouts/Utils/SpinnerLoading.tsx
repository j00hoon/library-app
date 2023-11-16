import Spinner from '../../Images/Etc/Bean Eater-1s-125px.gif';

export const SpinnerLoading = () => {
  
    return (
        <div className='container m-5 d-flex justify-content-center'
            style={{ height: 155 }} >
            {/* <div className='spinner-border text-primary' role='status'>
                <span className='visually-hidden'>
                    Loading...
                </span>
            </div> */}
            <img src={Spinner} alt="Spinner" />
        </div>
    );
}