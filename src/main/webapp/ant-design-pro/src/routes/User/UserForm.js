import React, { PureComponent } from 'react';
import { Form, Input, DatePicker, Select, Button, Card, Radio } from 'antd';

const FormItem = Form.Item;
const { Option } = Select;
const { RangePicker } = DatePicker;

@Form.create()
class UserForm extends PureComponent {
  handleSubmit = (e) => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((err, values) => {
      if (!err) {
      }
    });
  }
  render() {
    const { submitting } = this.props;
    const { getFieldDecorator } = this.props.form;

    const formItemLayout = {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 3 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 12 },
        md: { span: 10 },
      },
    };

    const submitFormLayout = {
      wrapperCol: {
        xs: { span: 24, offset: 0 },
        sm: { span: 10, offset: 3 },
      },
    };

    return (
      <div>
        <Card bordered={false}>
          <Form onSubmit={this.handleSubmit} hideRequiredMark style={{ marginTop: 24 }}>
            <FormItem
              {...formItemLayout}
              label="用户名"
            >
              <Input type="password"/>
            </FormItem>
            <FormItem
              {...formItemLayout}
            >
              <Radio.Group defaultValue={1}>
                <Radio value={1}>男</Radio>
                <Radio value={2}>女</Radio>
              </Radio.Group>
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="App Type"
              hasFeedback
            >
              {getFieldDecorator('appType', {
                rules: [{
                  required: true, message: 'application type is required',
                }],
              })(
                <Select placeholder="app type">
                  <Option value="type1">angular</Option>
                  <Option value="type2">react</Option>
                  <Option value="type3">vue</Option>
                </Select>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="Product Name"
              hasFeedback
            >
              {getFieldDecorator('productName', {
                rules: [{
                  required: true, message: 'product name is required',
                }],
              })(
                <Input placeholder="product name" />
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="App Name"
              hasFeedback
            >
              {getFieldDecorator('appName', {
                rules: [
                  { required: true, message: 'app name is required' },
                  { pattern: /^[a-zA-Z0-9-]+$/, message: 'only english, number and _' },
                ],
              })(
                <Input placeholder="only english, number and _" />
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="Date"
            >
              {getFieldDecorator('dateRange', {
                rules: [{ type: 'array', required: true, message: 'date is required' }],
              })(
                <RangePicker
                  format="YYYY-MM-DD"
                  placeholder={['begin', 'end']}
                  style={{ width: '100%' }}
                />
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="domain"
            >
              {getFieldDecorator('domain', {
                rules: [{ required: true, message: 'domain is required' }],
              })(
                <Input addonBefore="http://" addonAfter=".com" placeholder="facebook" style={{ width: '100%' }} />
              )}
            </FormItem>
            <FormItem {...submitFormLayout} style={{ marginTop: 40 }}>
              <Button type="primary" htmlType="submit" loading={submitting}>
                New
              </Button>
            </FormItem>
          </Form>
        </Card>
      </div>
    );
  }
}

export default UserForm
